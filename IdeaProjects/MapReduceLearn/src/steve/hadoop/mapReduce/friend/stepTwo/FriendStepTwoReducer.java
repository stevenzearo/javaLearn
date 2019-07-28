package steve.hadoop.mapReduce.friend.stepTwo;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class FriendStepTwoReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>();

        for (Text val: values
             ) {
            arrayList.add(val.toString());
        }
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = i+1; j < arrayList.size(); j++) {
                String commons = arrayList.get(i) + "-" + arrayList.get(j);
                context.write(key, new Text(commons));
            }
        }
    }
}
