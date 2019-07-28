package learn1;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

public class Learn1 {
    public static void main(String args[]) {
        System.out.println("hello, world!");
        try {
            String filename = "hdfs://localhost:900/hadoop2/test.txt";
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            if (!fs.exists(new Path(filename))) {
                System.out.println("文件不存在");
            } else {
                System.out.println("文件存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
