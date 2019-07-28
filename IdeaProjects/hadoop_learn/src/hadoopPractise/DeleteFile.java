package hadoopPractise;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class DeleteFile {
    public static void main(String args[]){
        try {
            Configuration conf = new Configuration();
            String filename = "hdfs://localhost:9000/user/hadoop/tianchi/result/";
            FileSystem fs = FileSystem.get(URI.create(filename),conf);
            Path path = new Path(filename);
            FileStatus status[] = fs.listStatus(new Path("hdfs://localhost:9000/user/hadoop/tianchi/"));
            for (int i=0; i<status.length; i++){
                System.out.println(status[i].getPath().toString());
            }
            fs.delete(path,true); // true/false设置是否递归删除
            System.out.println("file already deleted !!!");
            FileStatus status2[] = fs.listStatus(new Path("hdfs://localhost:9000/user/hadoop/tianchi/"));
            for (int i=0; i<status2.length; i++){
                System.out.println(status2[i].getPath().toString());
            }

        } catch (Exception e){
            e.printStackTrace();

        }
    }
}
