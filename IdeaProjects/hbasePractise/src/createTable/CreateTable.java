package createTable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

public class CreateTable {
    public static void main(String args[]) throws IOException {
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        String tableName = "tempTable1";
        String[] colFamilies = {"f1","f2","f3"};
        String[] columns = {"c1","c2","c3"};
        Admin admin = connection.getAdmin();
        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
        for (int i = 0; i < colFamilies.length; i++) {
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(colFamilies[i]);
            tableDescriptor.addFamily(columnDescriptor);
        }
        admin.createTable(tableDescriptor);
        admin.close();
        Table table = connection.getTable(TableName.valueOf(tableName));
        String rowKey = "r1";
        Put put = new Put(rowKey.getBytes());
        for (int i = 0; i < colFamilies.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                put.addColumn(colFamilies[i].getBytes(),columns[j].getBytes(),("value"+j).getBytes());
            }

        }
        table.put(put);
        table.close();
        connection.close();
        System.out.println("process finished!!!");
    }
}
