package steve.hadoop.mapReduce.index.stepOne;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.net.URI;

public class StepOneJobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000/");
        configuration.set("mapreduce.app-submission.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(StepOneJobSubmitter.class);
        job.setMapperClass(StepOneMapper.class);
        job.setReducerClass(StepOneReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        FileInputFormat.setInputPaths(job, new Path("wordCount/input/day0302-1"));
        Path path = new Path("wordCount/output/day0302-1");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");

    }

}
