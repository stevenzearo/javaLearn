package steve.hadoop.mapReduce.couponPartion.partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Test extends Partitioner<Text, IntWritable>{

    @Override
    public int getPartition(Text text, IntWritable intWritable, int i) {
        return 0;
    }
}
