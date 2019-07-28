package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class OrderReducer extends Reducer<OrderWritable, Text, OrderWritable, Text> {

    @Override
    protected void reduce(OrderWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Configuration configuration = context.getConfiguration();
        int n = configuration.getInt("top.n", 5);
        int count = 0;
        for (Text val: values
             ) {
            context.write(key, val);
            count ++;
            if (count == n) return;
        }
    }


}
