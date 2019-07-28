package steve.hadoop.mapReduce.discountWordCount.stepOne;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DiscountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
//        该方法在map方法被调用前执行一次
        super.setup(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(!key.equals(new LongWritable(0))){
            context.write(new Text(value.toString().split(",")[3]), new LongWritable(1));
        }
    }
}
