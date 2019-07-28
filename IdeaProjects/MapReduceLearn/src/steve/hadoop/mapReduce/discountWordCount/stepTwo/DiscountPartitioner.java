package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class DiscountPartitioner extends Partitioner<DiscountWritable, LongWritable> {

    /*
    * 重写分区方式
    * */
    @Override
    public int getPartition(DiscountWritable o, LongWritable o2, int i) {
        return (o.getDiscount().hashCode() & Integer.MAX_VALUE) % i;
    }
}
