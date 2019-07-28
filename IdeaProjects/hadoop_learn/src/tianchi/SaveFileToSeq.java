package tianchi;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.*;
import java.net.URI;

public class SaveFileToSeq {
    private String readFile;
    private String writePath;
    private String writeFile;
    private SaveFileToSeq(String readFile, String writePath, String writeFileName){
        this.readFile = readFile;
        this.writePath = writePath;
        this.writeFile = writePath + "/" + writeFileName;
    }
    private void createPath() {
        File path = new File(writePath);
        boolean status = path.exists();
        if (!status){
            path.mkdirs();
        } else {
            System.out.println("path is already existed!");
        }
    }
    private BufferedReader readFile(){
        BufferedReader bufReader;
        File read = new File(readFile);
        try{
            // 创建输出流
            FileInputStream stream = new FileInputStream(read);
            // 创建流读取器
            InputStreamReader reader = new InputStreamReader(stream);
            // 创建流读取器的缓冲器
            bufReader = new BufferedReader(reader);
        }catch (Exception e) {
            e.printStackTrace();
            bufReader = null;
        }
        return bufReader;
    }
    private String saveFileToSeq(BufferedReader bufReader){
        String head;
        Configuration conf = new Configuration();
        Path filePath = new Path(writeFile);
        SequenceFile.Writer writer = null;
        try {
            FileSystem fs = FileSystem.get(URI.create(writeFile),conf);
            // 创建键值对
            IntWritable key = new IntWritable();
            Text value = new Text();
            // 创建写入器
            writer = SequenceFile.createWriter(fs,conf,filePath,key.getClass(),value.getClass());
            head = bufReader.readLine();
            String line = bufReader.readLine();
            int i = 0;
            while (line != null) {
                // 键值对赋值
                key.set(i);
                value.set(line);
                // 写入键值对
                writer.append(key,value);
//                System.out.printf("[%s]\t%s\n",key,value);
                i++;
                line = bufReader.readLine();
            }
            System.out.println("file save to sequenceFile finished!");

        } catch (Exception e) {
            e.printStackTrace();
            head = "";
        }
        return head;
    }
    public static void main(String args[]) {
        String readPath = "/home/hadoop/data1/tianchi/offline_train.csv";
        String writePath = "hdfs://localhost:9000/user/hadoop/tianchi";
        String writeName = "offline_train_seq";
        SaveFileToSeq saveFile = new SaveFileToSeq(readPath,writePath,writeName);
        saveFile.createPath();
        BufferedReader bufReader = saveFile.readFile();
        String head = saveFile.saveFileToSeq(bufReader);
        System.out.println(head);
    }
}
