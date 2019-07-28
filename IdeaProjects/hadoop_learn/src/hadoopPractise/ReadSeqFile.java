package hadoopPractise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.SequenceFileRecordReader;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.DataInputStream;
import java.net.URI;

public class ReadSeqFile {
    public static void main(String args[]) {
        Configuration conf = new Configuration();
        String filePath = "hdfs://localhost:9000/user/hadoop/tianchi/offline_train_seq";
        Path path = new Path(filePath);
        SequenceFile.Reader reader = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(filePath), conf);
            reader = new SequenceFile.Reader(fs,path,conf);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(),conf);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(),conf);
            long position = reader.getPosition();

            while(reader.next(key,value)){

                System.out.printf("[%s]\t%s\n",key,value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}