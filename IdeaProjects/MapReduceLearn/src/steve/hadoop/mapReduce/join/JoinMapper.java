package steve.hadoop.mapReduce.join;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class JoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(",");
        if (words.length == 2){
            context.write(new Text(words[1]), new Text(words[0]));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String valueIn = null;
            for (int i = 1; i < words.length; i++) {
                stringBuilder.append(",").append(words[i]);
                 valueIn = stringBuilder.toString().replaceFirst(",", "");
            }
            context.write(new Text(words[0]), new Text(valueIn));
        }
    }
}
