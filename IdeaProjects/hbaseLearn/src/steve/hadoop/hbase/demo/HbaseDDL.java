package steve.hadoop.hbase.demo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.regionserver.BloomType;
import org.apache.hadoop.hbase.util.BloomFilter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HbaseDDL {

    public static Connection connection = null;
    @Before
    public void connection() throws IOException {
//        该类为HDFS的configuration的子类
        Configuration configuration = HBaseConfiguration.create();
        connection = ConnectionFactory.createConnection(configuration);

    }

    /*
    * DDL data definition language
    * */
//    创建表
    @Test
    public void createTable() throws IOException {

        //        构造ddl操作器
        Admin admin = connection.getAdmin();
//        创建表描述器
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("user_info"));
//        创建列族描述器
        HColumnDescriptor columnDescriptor1 = new HColumnDescriptor("basic_info");
        columnDescriptor1.setMaxVersions(3);
        HColumnDescriptor columnDescriptor2 = new HColumnDescriptor("extra_info");
        columnDescriptor2.setMaxVersions(3);

//        添加列族描述器到表描述器
        tableDescriptor.addFamily(columnDescriptor1);
        tableDescriptor.addFamily(columnDescriptor2);
//        创建表
        admin.createTable(tableDescriptor);

        admin.close();
        connection.close();
    }

//    删除表
    @Test
    public void dropTable() throws IOException {
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf("user_info"));
        admin.deleteTable(TableName.valueOf("user_info"));
        System.out.println("成功删除表user_info!!!");
        admin.close();
        connection.close();
    }

//    修改表定义
    @Test
    public void alterTable() throws IOException {
        Admin admin = connection.getAdmin();
        HTableDescriptor user_info = admin.getTableDescriptor(TableName.valueOf("user_info"));
        HColumnDescriptor other_info = new HColumnDescriptor("other_info");
//        设置布隆过滤器，可加快查询的速度和准确度
        other_info.setBloomFilterType(BloomType.ROW);
        user_info.addFamily(other_info);

        admin.modifyTable(TableName.valueOf("user_info"),user_info);
        admin.close();
        connection.close();

    }
    /*
    * DML data manipulation language
    * */

//    public static void main(String[] args) throws IOException {
//        HbaseDDL hbaseDemo = new HbaseDDL();
//        hbaseDemo.connection();
//        hbaseDemo.createTable();
//    }
}
