package userRateCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MyMapper extends Mapper<IntWritable, Text, Text, IntWritable> {
    private IntWritable one = new IntWritable(1);
    private Text userId = new Text();
    public void map(IntWritable key, Text value, Context context) throws
            IOException, InterruptedException {
        String line = value.toString();
        String[] lineList = line.split(",");
        userId.set(lineList[0]);
        context.write(userId, one);
    }

}