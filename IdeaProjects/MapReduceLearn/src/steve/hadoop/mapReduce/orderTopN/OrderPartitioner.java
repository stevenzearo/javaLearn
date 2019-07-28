package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class OrderPartitioner extends Partitioner<OrderWritable, Text> {
    @Override
    public int getPartition(OrderWritable orderWritable, Text text, int i) {
        return (orderWritable.getOrderId().hashCode() & Integer.MAX_VALUE) % i;
    }
}
