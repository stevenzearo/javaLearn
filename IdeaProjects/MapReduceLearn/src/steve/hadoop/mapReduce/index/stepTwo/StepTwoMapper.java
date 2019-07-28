package steve.hadoop.mapReduce.index.stepTwo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class StepTwoMapper extends Mapper<Text, IntWritable, Text, Text> {
    @Override
    protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        String[] words = key.toString().split("-");
        context.write(new Text(words[0]), new Text(words[1]+"-->"+value.get()));
    }
}
