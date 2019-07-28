package steve.hadoop.mapReduce.friend.stepOne;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FriendStepOneMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] words = value.toString().split(":");
        String user = words[0];
        String[] friends = words[1].split(",");
        for (String friend: friends
             ) {
            context.write(new Text(friend), new Text(user));
        }
    }
}
