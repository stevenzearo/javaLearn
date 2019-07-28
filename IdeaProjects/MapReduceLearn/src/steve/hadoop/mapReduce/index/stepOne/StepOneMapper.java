package steve.hadoop.mapReduce.index.stepOne;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class StepOneMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        FileSplit inputSplit =(FileSplit) context.getInputSplit();
        String fileName = inputSplit.getPath().getName();
        String[] words = value.toString().split(" ");
        for (String w: words
             ) {

            context.write(new Text(w+ "-" +fileName), new IntWritable(1));
        }
    }
}
