package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OrderMapper extends Mapper<LongWritable, Text, OrderWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(",");
        String orderId = words[0];
        OrderWritable orderWritable = new OrderWritable(words[0], words[1], words[2], Float.parseFloat(words[3]), Integer.parseInt(words[4]));
        context.write(orderWritable, new Text(orderId));
    }
}
