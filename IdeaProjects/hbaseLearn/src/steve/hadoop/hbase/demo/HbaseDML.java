package steve.hadoop.hbase.demo;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellScanner;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class HbaseDML {
    Connection connection = null;
    @Before
    public void connection() throws Exception {
        connection = ConnectionFactory.createConnection(HBaseConfiguration.create());
    }

    /*
    * 增,改(覆盖)
    * */
    @Test
    public void put() throws Exception {
        Table table = connection.getTable(TableName.valueOf("user_info"));
        Put put = new Put(Bytes.toBytes("0001"));
        put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("name"),Bytes.toBytes("tom"));
        put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("age"),Bytes.toBytes("23"));
        put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("addr"),Bytes.toBytes("beijing"));
        put.addColumn(Bytes.toBytes("extra_info"),Bytes.toBytes("carrier"),Bytes.toBytes("teacher"));
        put.addColumn(Bytes.toBytes("extra_info"),Bytes.toBytes("wage"),Bytes.toBytes("3300"));


        table.put(put);
        table.close();
        connection.close();
        System.out.println("数据添加完成！！！");
    }
    @Test
    public void multiplePut() throws Exception {
        Table table = connection.getTable(TableName.valueOf("user_info"));
        ArrayList<Put> putArrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Put put = new Put(Bytes.toBytes("0001"+i));
            put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("name"),Bytes.toBytes("tom"+i));
            put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("age"),Bytes.toBytes((23+i%10)+""));
            put.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("addr"),Bytes.toBytes("beijing"));
            put.addColumn(Bytes.toBytes("extra_info"),Bytes.toBytes("carrier"),Bytes.toBytes("teacher"));
            put.addColumn(Bytes.toBytes("extra_info"),Bytes.toBytes("wage"),Bytes.toBytes((3300+i)+""));
            putArrayList.add(put);
        }
        table.put(putArrayList);
        System.out.println("finished!!!");

    }
    /*
     * 删
     * */
    @Test
    public void delete() throws Exception {
        Table talble = connection.getTable(TableName.valueOf("user_info"));
        Delete delete = new Delete(Bytes.toBytes("0001"));
        delete.addColumn(Bytes.toBytes("basic_info"),Bytes.toBytes("addr"));
        talble.delete(delete);
        talble.close();
        connection.close();
    }

    /*
     * 查
     * */
    @Test
    public void get() throws Exception {
        Table table = connection.getTable(TableName.valueOf("user_info"));
        Get get = new Get(Bytes.toBytes("0001"));
        Result result = table.get(get);
        CellScanner cellScanner = result.cellScanner();
        while (cellScanner.advance()){
            Cell current = cellScanner.current();
            byte[] rowArray = current.getRowArray();
            byte[] familyArray = current.getFamilyArray();
            byte[] qualifierArray = current.getQualifierArray();
            byte[] valueArray = current.getValueArray();
            System.out.println("row key: "+new String(rowArray,current.getRowOffset(),current.getRowLength()));
            System.out.println("family name: "+new String(familyArray,current.getFamilyOffset(),current.getFamilyLength()));
            System.out.println("qualifier name: "+new String(qualifierArray,current.getQualifierOffset(),current.getQualifierLength()));
            System.out.println("value: "+new String(valueArray,current.getValueOffset(),current.getValueLength()));

        }
        table.close();
        connection.close();
        System.out.println("查询结束！！！");
    }

    @Test
    public void myScan() throws Exception {
        Table table = connection.getTable(TableName.valueOf("user_info"));
//        包含起始行不包含末尾行,若要包含末尾,则可在末尾键加上不可见字符\000
        Scan scan = new Scan(Bytes.toBytes("0001"),Bytes.toBytes("0001103\000"));
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> iterator = scanner.iterator();
        while (iterator.hasNext()){
            Result result = iterator.next();
            result.getRow();
            CellScanner cellScanner = result.cellScanner();
            while (cellScanner.advance()){
                Cell current = cellScanner.current();
                byte[] rowArray = current.getRowArray();
                byte[] familyArray = current.getFamilyArray();
                byte[] qualifierArray = current.getQualifierArray();
                byte[] valueArray = current.getValueArray();
                System.out.print(new String(rowArray,current.getRowOffset(),current.getRowLength())+"\t");
                System.out.print(new String(familyArray,current.getFamilyOffset(),current.getFamilyLength())+"\t");
                System.out.print(new String(qualifierArray,current.getQualifierOffset(),current.getQualifierLength())+"\t");
                System.out.print(new String(valueArray,current.getValueOffset(),current.getValueLength())+"\n");
            }

        }
    }
}
