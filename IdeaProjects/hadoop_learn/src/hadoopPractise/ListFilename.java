package hadoopPractise;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileStatus;

public class ListFilename {
public static void main(String args[]){
    try{
        String uri = "hdfs://localhost:9000/user/hadoop/input";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri),conf);
        Path path = new Path(uri);
        FileStatus stats[] = fs.listStatus(path);
        for (int i=0; i < stats.length; i++){
            System.out.println(stats[i].getPath().toString());
        }
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
