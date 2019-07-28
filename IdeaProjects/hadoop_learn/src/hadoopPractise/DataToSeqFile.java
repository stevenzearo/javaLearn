package hadoopPractise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.*;
import java.net.URI;

public class DataToSeqFile {
    private String readPath;
    private String writePath;
    private File readFile;
    private SequenceFile writeFile;

    DataToSeqFile(String readPath, String writePath) {
        this.readPath = readPath;
        this.writePath = writePath;
    }

    public FileInputStream getReadStream() {

        readFile = new File(readPath);
        try {
            FileInputStream stream = new FileInputStream(readFile);
            return stream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void writeFileToSeq(FileInputStream stream){
        Configuration conf = new Configuration();
        Path path = new Path(writePath);
        SequenceFile.Writer writer = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(writePath),conf);
            IntWritable key = new IntWritable();
            Text value = new Text();
            // 创建写入器
            writer = SequenceFile.createWriter(fs,conf,path,key.getClass(),value.getClass());
            InputStreamReader isr = new InputStreamReader(stream);
            BufferedReader d = new BufferedReader(isr);
            int i = 0;
            System.out.println(d.readLine());
            String line = d.readLine();

            while (line != null) {
                value.set(line);
                key.set(i);
                writer.append(key,value);
                System.out.printf("[%s]\t%s\n",key,value);
                i++;
                line = d.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        String readFile = "/home/hadoop/data1/operation_round1_new.csv";
        String writeFile = "hdfs://localhost:9000/user/hadoop/mydata/operation_round1_new_seq";
        DataToSeqFile data = new DataToSeqFile(readFile,writeFile);
        FileInputStream stream = data.getReadStream();
        data.writeFileToSeq(stream);

    }
}
