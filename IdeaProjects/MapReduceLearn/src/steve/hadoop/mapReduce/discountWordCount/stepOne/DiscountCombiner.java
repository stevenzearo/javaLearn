package steve.hadoop.mapReduce.discountWordCount.stepOne;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class DiscountCombiner extends Reducer <Text, LongWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long count = 0l;
        for (LongWritable val: values
        ) {
            count += val.get();
        }
        context.write(key, new LongWritable(count));
    }

}
