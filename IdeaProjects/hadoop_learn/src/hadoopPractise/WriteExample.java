package hadoopPractise;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;

public class WriteExample {
    public static void main(String args[]){
        try {
            Configuration conf = new Configuration();
            String filename = "hdfs://localhost:9000/user/hadoop/input/hello.txt";
            FileSystem fs = FileSystem.get(URI.create(filename),conf);
            Path path = new Path(filename);
            String buff = "Hello, world!......你好！";
            FSDataOutputStream os = fs.create(path);
            os.writeBytes(new String(buff.getBytes("utf8")));
            System.out.println(new String(buff.getBytes("utf8")));

            System.out.println("Create: " + filename);




        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
