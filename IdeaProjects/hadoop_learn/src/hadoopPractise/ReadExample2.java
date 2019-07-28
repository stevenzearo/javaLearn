package hadoopPractise;

import java.net.URI;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataInputStream;

public class ReadExample2 {
    public static void main(String args[]){
        try{
            Configuration conf = new Configuration();
            String filename = "/home/hadoop/data1/operation_round1_new.csv";
            Path path = new Path(filename);
            FileSystem fs = FileSystem.get(URI.create(filename),conf);
            // 数据从磁盘输入到内存
            FSDataInputStream stream = fs.open(path);
            InputStreamReader file = new InputStreamReader(stream,"default");
            // 数据缓冲
            BufferedReader d= new BufferedReader(file);stream.available();
            for (int i=0; i <1; i ++) {
                System.out.println(d.readLine());

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
