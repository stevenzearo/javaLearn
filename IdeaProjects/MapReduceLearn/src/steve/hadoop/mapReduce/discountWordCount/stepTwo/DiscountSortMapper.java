package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DiscountSortMapper extends Mapper<LongWritable, Text, DiscountWritable, LongWritable> {

    private DiscountWritable discountWritable = new DiscountWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split("\t");
        discountWritable.setDiscount(words[0]);
        discountWritable.setNum(Long.parseLong(words[1]));
        context.write(discountWritable, new LongWritable(Long.parseLong(words[1])));
    }
}
