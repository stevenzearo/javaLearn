package steve.hadoop.mapReduce.couponPartion.aggregate;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class AggregateJobSubmitter {
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set("mapreduce.app-submitter.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setNumReduceTasks(1);
        job.setJarByClass(AggregateJobSubmitter.class);
        job.setMapperClass(AggregateMapper.class);
        job.setReducerClass(AggregateReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, "tianchi/input/wordCount");
        Path path = new Path("tianchi/output/wordCount0301-2/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");
    }

}
