package hdfsWordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HdfsWordCount {
    public static void main(String[] args) throws Exception {

        /*
        * 初始工作
        *
        * */
        Properties properties = new Properties();
//        加载配置文件
        properties.load(HdfsWordCount.class.getClassLoader().getResourceAsStream("wordCount.properties"));
        Class<?> mapperClass = Class.forName(properties.getProperty("MAPPER_CLASS"));

        Mapper mapper = (Mapper) mapperClass.newInstance();
        Context context = new Context();
        /*
        * 处理数据
        *
        * */
//        按行读取hdfs中的文件(多个文件)
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"),configuration);
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("wordCount/input/"), true);
        while (iterator.hasNext()){
            LocatedFileStatus next = iterator.next();
            FSDataInputStream fsDataInputStream = fileSystem.open(next.getPath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream));
            String line = null;
//            逐行读取文件
            while ((line = bufferedReader.readLine())!=null){
//        调用方法进行业务处理

                mapper.map(line, context);

            }
            bufferedReader.close();
            fsDataInputStream.close();
        }

        /*
        * 输出结果
        *
        * */
//        调用方法将数据存入缓存
        HashMap<Object, Object> contextMap = context.getContextMap();
        Path outPath = new Path("wordCount/output/");
        if (!fileSystem.exists(outPath)){
            fileSystem.mkdirs(outPath);
        }
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("wordCount/output/result.dta"));
        for (Map.Entry<Object, Object> entry: contextMap.entrySet()
             ) {
            fsDataOutputStream.write((entry.getKey().toString() + "\t" + entry.getValue().toString() + "\n").getBytes());

        }
        fsDataOutputStream.close();
//        调用方法将处理结果保存到hdfs
        fileSystem.close();
        System.out.println("数据统计完成!!!");
    }

}
