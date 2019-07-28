package hadoopPractise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;

public class SequenceReaderExample {
    public static void main(String args[]) {
        String seqPath = "hdfs://localhost:9000/user/hadoop/mydata/seqfile";
        Configuration conf = new Configuration();
        Path path = new Path(seqPath);
        SequenceFile.Reader reader = null;
        try {

            FileSystem fs = FileSystem.get(URI.create(seqPath),conf);
            reader = new SequenceFile.Reader(fs,path,conf);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(),conf);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(),conf);
            while (reader.next(key,value)){
                System.out.printf("[%s]\t%s\n",key,value);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
