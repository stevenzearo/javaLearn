package steve.hadoop.mapReduce.couponRateCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CouponMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key != new LongWritable(0)){
            String line = value.toString();
            String[] words = line.split(",");
            String userId = words[0];
            String couponId = words[2];
            if ((userId.length() != 0)&&(!couponId.equals("null"))) {


                context.write(new Text(userId+"-"+couponId), new IntWritable(1));
            }
        }
    }
}
