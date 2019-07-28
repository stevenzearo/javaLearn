package steve.hadoop.day04.mapReduce.merchantAggregate;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class MerchantJobSubmitter {
    public static void main(String[] args) throws Exception{

        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.setInt("top.n", 50);
        configuration.set("mapreduce.app-submission.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setNumReduceTasks(1);
        job.setJarByClass(MerchantJobSubmitter.class);
        job.setMapperClass(MerchantMapper.class);
        job.setReducerClass(MerchantReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path("tianchi/input/wordCount/"));

        Path outputPath = new Path("tianchi/output/wordCount0301/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(outputPath)) {
            fileSystem.delete(outputPath, true);
        }

        FileOutputFormat.setOutputPath(job, outputPath);

        boolean status = job.waitForCompletion(true);
        System.out.println(status ? "程序顺利运行完成！！！" : "程序异常！！！");
    }

}
