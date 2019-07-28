package hadoopPractise;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

public class MakeDirection {
    public static void main(String args[]){
        try {
            Configuration conf = new Configuration();
            String uri = "hdfs://localhost:9000/user/hadoop/exampleDelete/";
            FileSystem fs = FileSystem.get(URI.create(uri),conf);
            Path path = new Path(uri);
            fs.mkdirs(path); // 创建文件目录
            FileStatus status[] = fs.listStatus(new Path("hdfs://localhost:9000/user/hadoop/"));
            for (int i=0; i < status.length; i++){
                // 输出文件目录
                System.out.println(status[i].getPath().toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
