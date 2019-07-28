package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class Test {
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), configuration);
        Path path = new Path("mydata");
        boolean exists = fileSystem.exists(path);
        System.out.println(exists);

    }

}
