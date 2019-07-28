package steve.hadoop.mapReduce.join;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        ArrayList<String> ordersInfo = new ArrayList<>();
        ArrayList<String> usersInfo = new ArrayList<>();
        for (Text val: values
             ) {
            String[] valSplit = val.toString().split(",");
            if (valSplit.length >= 2){
                usersInfo.add(val.toString());
            }
            else {
                ordersInfo.add(val.toString());
            }
        }
        for (int i = 0; i < ordersInfo.size(); i++) {
            for (int j = 0; j < usersInfo.size(); j++) {
                context.write(key, new Text(key.toString()+","+usersInfo.get(j)+","+ ordersInfo.get(i)));

            }

        }
    }
}
