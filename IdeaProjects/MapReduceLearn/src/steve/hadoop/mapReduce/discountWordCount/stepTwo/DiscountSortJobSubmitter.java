package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import steve.hadoop.mapReduce.discountWordCount.stepOne.DiscountJobSubmitter;

import java.net.URI;

public class DiscountSortJobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set("mapreduce.app-submitter.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(DiscountJobSubmitter.class);
        job.setMapperClass(DiscountSortMapper.class);
        job.setReducerClass(DiscountSortReducer.class);
        job.setGroupingComparatorClass(DiscountGroupingComparator.class);
        job.setPartitionerClass(DiscountPartitioner.class);
        job.setNumReduceTasks(1);
        job.setMapOutputKeyClass(DiscountWritable.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(DiscountWritable.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, "tianchi/output/discountCount0303-1/");
        Path path = new Path("tianchi/output/discountCount0303-1-2/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");
    }

}
