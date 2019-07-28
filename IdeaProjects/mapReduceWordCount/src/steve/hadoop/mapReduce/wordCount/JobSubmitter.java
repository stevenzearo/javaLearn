package steve.hadoop.mapReduce.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class JobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://localhost:9000/");
//        设置job提交的位置为yarn集群的resourcemanager的集群中的位置
        configuration.set("mapreduce.framework.name","yarn");
        configuration.set("yarn.resourcemanager.hostname","steve-loc");
//        设置跨平台提交任务的参数,windows平台提交任务时为true
        configuration.set("mapreduce.app-submission.cross-platform","false");


//        生成job任务
        Job job = Job.getInstance(configuration);
//        设置job调用的jar包路径
        job.setJarByClass(JobSubmitter.class);
//        设置Mapper实现类的jar包路径
        job.setMapperClass(WordCountMapper.class);
//        设置Reducer实现类的jar包路径
        job.setReducerClass(WordCountReducer.class);
//        设置mapper产生的key,value数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
//        设置reducer产生（输出结果）的key,value数据类型

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
//        设置输入数据集所在路径
        FileInputFormat.setInputPaths(job, new Path("tianchi/input/wordCount/"));

        Path outPutPath = new Path("tianchi/output/wordCount0216/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
        if (fileSystem.exists(outPutPath)) {
            fileSystem.delete(outPutPath, true);
        }
        FileOutputFormat.setOutputPath(job, outPutPath);

//        设置reduce task个数
        job.setNumReduceTasks(4);
//        提交job到yarn集群
//        submit提交后程序结束,不知道yarn集群的运行情况
//        job.submit();
        boolean jobStatus = job.waitForCompletion(true);
        System.out.println(
                jobStatus ? "mapReduce程序运行成功！！！" : "mapReduce程序运行失败！！！"
        );


    }

}
