package steve.hadoop.mapReduce.couponPartion.partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class UserSortJobSubmitter {
    static int getReduceTaskNum() throws  Exception {
        int count = 0;
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        FSDataInputStream fsDataInputStream = fileSystem.open(new Path("tianchi/output/wordCount0301-2/part-r-00000"));
        InputStreamReader reader = new InputStreamReader(fsDataInputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            count += 1;
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000/");
        configuration.set("mapreduce.app-submission.cross-platform", "false");
        Job job = Job.getInstance(configuration);

        int num = UserSortJobSubmitter.getReduceTaskNum();
        job.setNumReduceTasks(num);

        System.out.println("**********************************");
        System.out.println(num);
        System.out.println("**********************************");
        job.setJarByClass(UserSortJobSubmitter.class);
        job.setMapperClass(UserSortMapper.class);
        job.setReducerClass(UserSortReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setPartitionerClass(CouponPartitioner.class);

        FileInputFormat.setInputPaths(job, new Path("tianchi/input/wordCount"));
        Path path = new Path("tianchi/output/wordCount0301-3/");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration());
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        FileOutputFormat.setOutputPath(job, path);
        boolean status = job.waitForCompletion(true);

        System.out.println(status ? "程序顺利执行完成！！！" : "程序异常！！！");

    }

}
