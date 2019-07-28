package steve.hadoop.mapReduce.couponPartion.partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class UserSortReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private ArrayList<User> userArrayList = new ArrayList<>();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable val: values
             ) {
            count += val.get();
        }
        String userId = key.toString();
        userArrayList.add(new User(userId, count));
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
//        设置降序排序
        userArrayList.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return t1.getNum() - user.getNum();
            }
        });
        for (User user: userArrayList
             ) {
            context.write(new Text(user.getUserId()), new IntWritable(user.getNum()));
        }
    }
}
