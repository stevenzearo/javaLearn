package steve.hadoop.mapReduce.discountWordCount.stepOne;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class DiscountJobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set("mapreduce.app-submitter.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(DiscountJobSubmitter.class);
        job.setMapperClass(DiscountMapper.class);
        job.setCombinerClass(DiscountCombiner.class);
        job.setReducerClass(DiscountReducer.class);

        job.setNumReduceTasks(1);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, "tianchi/input/wordCount");
        Path path = new Path("tianchi/output/discountCount0303-1/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");
    }

}
