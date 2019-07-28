package steve.hadoop.hdfs.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import steve.hadoop.hdfs.Mapper.Mapper;
import steve.hadoop.hdfs.Reducer.Reducer;
import steve.hadoop.hdfs.context.Context;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WordCountMain {
    public static void main(String[] args) throws Exception {
        /*
        * 条件初始化
        * */
        Configuration configuration = new Configuration();

//        通过代理加载WorldCountMapper类和WorldCountReducer类
        Properties properties = new Properties();
        properties.load(WordCountMain.class.getClassLoader().getResourceAsStream("wordCount.properties"));
        Class<?> className1 = Class.forName(properties.getProperty("MAPPER"));
        Class<?> className2 = Class.forName(properties.getProperty("REDUCER"));
        Mapper mapper = (Mapper) className1.newInstance();
        Reducer reducer = (Reducer) className2.newInstance();

        Context context = new Context();


        /*
        * 读取文件
        *
        * */
        System.out.println("开始读取文件！！！");
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"),configuration);
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("tianchi/input/wordCount"), true);
        int n = 0;
        while (iterator.hasNext()){

            LocatedFileStatus fileStatus = iterator.next();
            FSDataInputStream fsDataInputStream = fileSystem.open(fileStatus.getPath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream));

//            忽略首行信息
            bufferedReader.readLine();
            String line = null;

//            逐行读取文件信息
            while ((line = bufferedReader.readLine()) != null) {

                String userId = line.split(",")[0];

                if (userId.length() > 0){

//                    map操作
                    mapper.map(userId, context);

                }
            }
            fsDataInputStream.close();
            bufferedReader.close();

            /*
             * 中间结果保存到本地
             *
             * */
            HashMap<Object, Object> contextMap = context.getContextMap();
            File file = new File("home/hadoop/temp/temp"+n+".dat");
            if (file.exists()){

                file.delete();

            }


            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contextMap);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("map part"+n+" 操作完成！！！");
            n++;
        }
        System.out.println("map操作完成！！！");


        System.out.println("中间结果保存成功！！！");
        /*
        * reduce操作
        *
        * */
        Context reduceContext = new Context();
        for (int i = 0; i < n; i++) {
            File file = new File("home/hadoop/temp/temp"+i+".dat");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<Object, Object> reduceMap = (HashMap<Object, Object>) objectInputStream.readObject();

            Context reduceContext1 = new Context();
            reduceContext1.setContextMap(reduceMap);
            reduceContext = reducer.combineContext(reduceContext1, reduceContext);
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("reduce准备操作part"+i+"完成！！！");
            file.delete();

        }
        ArrayList<Map.Entry<Object, Object>> result = reducer.reduce(reduceContext, true);


        System.out.println("reduce操作完成！！！");
        Path resultPath = new Path("tianchi/output/wordCount/");
        if (fileSystem.exists(resultPath)) {
            fileSystem.delete(resultPath, true);
        }
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("tianchi/output/wordCount/result.dat"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream));
        writer.write("result:\n");
        for (Map.Entry entry : result) {
            String key = (String) entry.getKey();
            int value = (int) entry.getValue();
            writer.write("key: "+key+"\t"+"value: "+value+"\n");
        }
        writer.close();
        fsDataOutputStream.close();
        fileSystem.close();
        System.out.println("文件保存成功！！！");
        System.out.println("wordCount操作完成！！！");

        /*
        * reduce操作结果保存到hdfs
        *
        *
        * */



    }

}
