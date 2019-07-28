package steve.hadoop.mapReduce.index.stepTwo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class StepTwoReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
//        StringBuilder stringBuilder = new StringBuilder();

        String line = "";
        for (Text val: values
             ) {
            line += val + " ";
//          stringBuilder.append(val.toString()).append(" ");
        }
        line.trim();
//        context.write(key, new Text(stringBuilder.toString().trim());
        context.write(key, new Text(line));
    }
}
