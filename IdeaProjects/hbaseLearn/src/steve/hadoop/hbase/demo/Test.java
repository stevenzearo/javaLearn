package steve.hadoop.hbase.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class Test {
    @org.junit.Test
    public void test(){
        System.out.println("hello,world!");
    }
    public static void main(String[] args) throws IOException {
        System.out.println("hello,world!");
        Configuration configuration = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(configuration);
        boolean closed = connection.isClosed();
        System.out.println(closed);
    }

}
