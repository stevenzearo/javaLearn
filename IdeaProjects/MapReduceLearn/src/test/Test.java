package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class Test {
    public static void main(String[] args) throws Exception {
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"), new Configuration());
        boolean status = fileSystem.exists(new Path("tianchi"));
        System.out.println(status);
    }
}
