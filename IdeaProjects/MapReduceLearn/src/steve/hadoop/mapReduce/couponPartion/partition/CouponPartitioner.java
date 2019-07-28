package steve.hadoop.mapReduce.couponPartion.partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class CouponPartitioner extends Partitioner<Text, IntWritable> {


    static HashMap<String, Integer> codeMap = new HashMap<>();
    static int count = 0;
    static {
        try (FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000"), new Configuration())) {
            FSDataInputStream fsDataInputStream = fileSystem.open(new Path("tianchi/output/wordCount0301-2/part-r-00000"));
            InputStreamReader reader = new InputStreamReader(fsDataInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String discount = line.split("\t")[0];
                codeMap.put(discount, count);
                count += 1;
            }
        } catch (Exception e) {
            System.out.println("CouponPartition Error!!!");
        }

    }

    @Override
    public int getPartition(Text key, IntWritable value, int i) {
        String disInKey = key.toString().split("-")[1];
        if ((codeMap.get(disInKey)) != null) {
            return codeMap.get(disInKey);
        }
        return 0;
    }

}
