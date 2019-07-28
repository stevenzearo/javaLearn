package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class OrderJobSubmitter {
    public static void main(String[] args) throws Exception{

        System.getProperty("HADOOP_USER_HOME", "root");
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000/");
        configuration.set("mapreduce.framework.name", "yarn");
        configuration.set("yarn.resourcemanager.hostname", "steve-loc");
        configuration.setInt("top.n", 3);
        configuration.set("mapreduce.app-submission.cross-platform", "false");
        Job job = Job.getInstance(configuration);
        job.setJarByClass(OrderJobSubmitter.class);
//        job.setJar("/home/hadoop/IdeaProjects/MapReduceLearn/src/steve/hadoop/mapReduce/orderTopN.jar");
        job.setPartitionerClass(OrderPartitioner.class);
        job.setGroupingComparatorClass(OrderIdGroupingComparator.class);
        job.setMapperClass(OrderMapper.class);
        job.setReducerClass(OrderReducer.class);
        job.setMapOutputKeyClass(OrderWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(OrderWritable.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(3);

        FileInputFormat.setInputPaths(job, new Path("wordCount/input/top-n-02.txt"));

        Path path = new Path("wordCount/output/wordCount0301-1/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
        if (fileSystem.exists(path)){
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");
    }

}
