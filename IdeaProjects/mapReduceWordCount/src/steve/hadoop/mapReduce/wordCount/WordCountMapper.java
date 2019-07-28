package steve.hadoop.mapReduce.wordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/*
* KEYIN 指定输入到map Task的key类型
* VALUEIN 指定输入到map Task的value类型
* KEYOUT 指定输入到reduce Task（用户返回的）key类型
* VALUEOUT 指定输入到reduce Task（用户返回的）value类型
* */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        舍弃第一行（第一行为特征名）
        if (key != new LongWritable(0)) {

//            获取userId
            String line = value.toString();
            String[] words = line.split(",");
            String userId = words[0];
            if (userId.length() != 0) {
                context.write(new Text(userId), new IntWritable(1));
            }
        }
    }
}
