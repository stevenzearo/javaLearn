package userRateCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class UserRateCount {

    public static void main(String args[]) throws IOException, ClassNotFoundException,
            InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf,"user rate count");
        job.setInputFormatClass(SequenceFileInputFormat.class);

        job.setJarByClass(UserRateCount.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job,
                new Path("hdfs://localhost:9000/user/hadoop/tianchi/offline_train_seq"));

        FileOutputFormat.setOutputPath(job,
                new Path(args[0]));
        System.exit(job.waitForCompletion(true)? 0 : 1);
    }
}

