package hadoopPractise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.SequenceFile;
import java.net.URI;

public class SequenceFileExample {
    private static final String[] text = {
            "0001",
            "0002",
            "0003",
            "0004",
    };
    public static void main(String args[]) {
        String uri = "hdfs://localhost:9000/user/hadoop/mydata/seqfile";
        Configuration conf = new Configuration();
        Path path = new Path(uri);
        SequenceFile.Writer writer = null;
        try{
            FileSystem fs = FileSystem.get(URI.create(uri),conf);
            IntWritable key = new IntWritable();
            Text value = new Text();
            writer = SequenceFile.createWriter(fs,conf,path,key.getClass(),value.getClass());
            for (int i=0; i<100; i++){
                key.set(i);
                value.set(text[i%text.length]);
                writer.append(key,value);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(writer);
        }
    }
}
