package steve.hadoop.mapReduce.couponPartion.partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class UserSortMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))){
            String line = value.toString();
            String[] words = line.split(",");
            String userId = words[0];
            String discount = words[3];
            context.write(new Text(userId+"-"+discount), new IntWritable(1));
        }
    }
}
