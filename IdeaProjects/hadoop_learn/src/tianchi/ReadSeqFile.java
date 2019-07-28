package tianchi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathExistsException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ExitUtil;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ReadSeqFile {
    private String fileName;
    ReadSeqFile(String fileName){
        Configuration conf = new Configuration();
        Path hdfsPath = new Path(fileName);
        try {
            FileSystem fs = FileSystem.get(URI.create(fileName),conf);
//          路径状态
            boolean status = fs.exists(hdfsPath);
            if (!status){
                throw new PathExistsException("Path is not exist");

            } else {

                this.fileName = fileName;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private Map<String,Writable> readSeqFile(){
        Map<String,Writable> map = new HashMap<String,Writable>();
        Configuration conf = new Configuration();
        Path filePath = new Path(fileName);
        SequenceFile.Reader reader;
        Writable key;
        Writable value;
        try {
            FileSystem fs = FileSystem.get(URI.create(fileName),conf);
//          创建读取器
            reader = new SequenceFile.Reader(fs, filePath, conf);
//          创建键值对b
            key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(),conf);
            value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(),conf);
            reader.next(key,value);
            System.out.printf("[%s]\t%s\n",key,value);

        }catch (Exception e){
            e.printStackTrace();
            key = null;
            value = null;
        }
        map.put("key",key);
        map.put("value",value);
        return map;
    }
    public static void main(String args[]) {
        Writable key;
        Writable value;
        ReadSeqFile reader = new ReadSeqFile("hdfs://localhost:9000/user/hadoop/tianchi/offline_train_seq");
        Map<String,Writable> map = reader.readSeqFile();
        key = map.get("key");
        value = map.get("value");
        System.out.printf("[%s]\t%s\n",key,value);

    }
}
