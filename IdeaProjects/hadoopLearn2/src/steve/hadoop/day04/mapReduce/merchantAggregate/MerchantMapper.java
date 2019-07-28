package steve.hadoop.day04.mapReduce.merchantAggregate;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;

public class MerchantMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))) {
            String line = value.toString();
            String[] words = line.split(",");
            String merchantId = words[0];
            if (merchantId.length() > 0) {
                context.write(new Text(merchantId), new IntWritable(1));
            }
        }
    }
}
