package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DiscountSortReducer extends Reducer<DiscountWritable, LongWritable, DiscountWritable, LongWritable> {
    @Override
    protected void reduce(DiscountWritable key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long count = 0;
        for (LongWritable val: values
             ) {
            count += val.get();
        }
        DiscountWritable keyOut = new DiscountWritable(key.getDiscount(), count);
        context.write(keyOut, new LongWritable(keyOut.getNum()));
    }
}
