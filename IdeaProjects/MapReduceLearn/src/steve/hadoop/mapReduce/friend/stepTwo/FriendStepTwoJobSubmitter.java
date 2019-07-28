package steve.hadoop.mapReduce.friend.stepTwo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

public class FriendStepTwoJobSubmitter {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000/");
        configuration.set("mapreduce.app-submission.cross-platform", "false");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(FriendStepTwoJobSubmitter.class);
        job.setMapperClass(FriendStepTwoMapper.class);
        job.setReducerClass(FriendStepTwoReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.setInputPaths(job, new Path("wordCount/output/friends/stepOne"));
        Path path = new Path("wordCount/output/friends/stepTwo");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);

        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");
    }

}
