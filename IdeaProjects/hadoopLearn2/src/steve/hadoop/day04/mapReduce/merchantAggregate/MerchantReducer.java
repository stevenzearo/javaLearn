package steve.hadoop.day04.mapReduce.merchantAggregate;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class MerchantReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private ArrayList<Merchant> arrayList = new ArrayList<>();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable val: values
             ) {
            count += val.get();
        }
//        context.write(key, new LongWritable(count));
        arrayList.add(new Merchant(key.toString(), count));
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
//        自定义排序方式(降序排列)进行排序
        arrayList.sort(new Comparator<Merchant>() {
            @Override
            public int compare(Merchant merchant, Merchant t1) {
                return t1.getFrequence() - merchant.getFrequence();
            }
        });
        Configuration configuration = context.getConfiguration();
        int topN = configuration.getInt("top.n", 20);
        for (int i = 0; i < topN; i++) {
            context.write(new Text(arrayList.get(i).getId()), new IntWritable(arrayList.get(i).getFrequence()));

        }

    }
}
