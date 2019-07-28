package steve.hadoop.mapReduce.couponRateCount;

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

public class CouponJobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();

//        设置环境变量
//        设置默认的文件系统
        configuration.set("fs.defaultFS", "hdfs://localhost:9000/");

//        设置执行任务的框架名
        configuration.set("mapreduce.framework.name","yarn");
//        设置执行任务的服务器名
        configuration.set("yarn.resourcemanager.hostname","localhost");
        configuration.set("mapreduce.app-submission.cross-platform","false");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(CouponJobSubmitter.class);
        job.setMapperClass(CouponMapper.class);
        job.setReducerClass(CouponReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, new Path("tianchi/input/wordCount"));
        Path outputPath = new Path("tianchi/output/wordCount0225/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
        if (fileSystem.exists(outputPath)) {
            fileSystem.delete(outputPath, true);
        }

        FileOutputFormat.setOutputPath(job, outputPath);
        job.setNumReduceTasks(2);

        boolean status = job.waitForCompletion(true);

        System.out.println(status?"程序顺利执行完成！！！":"程序异常！！！");
    }

}
