package hadoopPractise;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class ReadExample{
    public static void main(String args[]){
        try {
            //加载环境变量配置
            Configuration conf = new Configuration();
            //加载文件系统
            FileSystem fs = FileSystem.get(conf);
            //加载文件路径
            Path path = new Path("/home/hadoop/hadoop/input/hdfs-site.xml");
            //读取文件
            FSDataInputStream is = fs.open(path);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader d = new BufferedReader(isr);
            while (d.read() != -1){
                System.out.println(d.readLine());
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}