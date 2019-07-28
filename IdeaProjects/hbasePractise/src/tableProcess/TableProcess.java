package tableProcess;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class TableProcess {

    private Connection connection;

    TableProcess() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        connection = ConnectionFactory.createConnection(conf);
    }

    private void closeAll() throws IOException {
        connection.close();
    }

    private void createTable(String tableName,
            String[] colFamiliesName) throws IOException {
        // Admin仅在创建和删除表格时用到
        Admin admin = connection.getAdmin();
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        for (int i = 0; i < colFamiliesName.length; i++) {
            HColumnDescriptor colFamily = new HColumnDescriptor(colFamiliesName[i]);
            table.addFamily(colFamily);
        }
        admin.createTable(table);
        admin.close();
        System.out.println("create table successfully!");
    }

    private void deleteTable(String tableName) throws IOException {
        Admin admin = connection.getAdmin();
        admin.disableTable(TableName.valueOf(tableName));
        admin.deleteTable(TableName.valueOf(tableName));
        admin.close();
        System.out.println("delete table successfully!");
    }
    private void insertValue(String tableName, String rowKey,
                String colFamily, String[] columns, String[] values) throws IOException {
        /**添加值时一次仅能添加一个列族的一行的所有可能值
         *此方法可改进之出：列名和值作为键值对传入
         *
         */
        // 获取表
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowKey.getBytes());
        for (int i = 0; i < columns.length; i++) {
            put.addColumn(colFamily.getBytes(),columns[i].getBytes(),values[i].getBytes());
        }
        table.put(put);
        table.close();
        System.out.println("insert value successfully!");
    }

    private void deleteValue(String tableName, String rowKey, String colFamily, String[] columns)
            throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(rowKey.getBytes());
        for (int i = 0; i < columns.length; i++) {
            delete.addColumn(colFamily.getBytes(),columns[i].getBytes());

        }
        table.delete(delete);
        table.close();
        System.out.println("delete values successfully!");
    }

    private void getValue(String tableName,
                String rowKey, String colFamily, String[] columns) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(rowKey.getBytes());
        for (int i = 0; i < columns.length; i++) {
            get.addColumn(colFamily.getBytes(),columns[i].getBytes());
            Result result = table.get(get);
            String valueStr = Bytes.toString(result.getValue(colFamily.getBytes(),columns[i].getBytes()));
            System.out.println(valueStr);
        }
        table.close();
    }

    private void scanValue(String tableName, String startRow,
                String stopRow, String colFamily, String column) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        scan.setStartRow(startRow.getBytes());
        scan.setStopRow(stopRow.getBytes());
        scan.addColumn(colFamily.getBytes(),column.getBytes());
        ResultScanner rs = table.getScanner(scan);
        for (Result result: rs) {
            String valueStr = Bytes.toString(result.getValue(colFamily.getBytes(),column.getBytes()));
            System.out.println(valueStr);
        }
        table.close();
    }
    public static void main(String args[]) throws IOException {
        TableProcess tableProcess = new TableProcess();
        String tableName = "tempTable3";
        String[] colFamilies = {"f1","f2","f3"};
//        tableProcess.createTable(tableName, colFamilies);
        String[] columns = {"c1","c2","c3"};
        String[] values = {"v1","v2","v3"};
//        tableProcess.insertValue("tempTable3","r1","f1",columns,values);
//        tableProcess.scanValue("tempTable3","r1","r1","f1",columns[0]);
        String[] columns2 = {"c1","c3"};
//        tableProcess.getValue("tempTable3","r1","f1",columns2);
        tableProcess.deleteValue("tempTable3","r1","f1",columns2);
//        tableProcess.deleteTable("tempTable3");
        tableProcess.closeAll();
    }
}
