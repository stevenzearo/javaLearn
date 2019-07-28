package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;

public class HdfsClientDemo {
    public void uploadFile(String local, String hdfs){
        Configuration configuration = new Configuration();
        Path localPath = new Path(local);
        Path hdfsPath = new Path(hdfs);
        try {
            FileSystem fileSystem = FileSystem.get(URI.create(hdfs), configuration);
            fileSystem.copyFromLocalFile(localPath,hdfsPath);


        } catch (Exception e) {
            System.out.println("uploadFile方法异常！！！");
        }

    }

    public boolean fileExistence(String filePath) {
        /*
        * configuration加载顺序
        *   1,xx-default.xml
        *   2,xx-site.xml
        *   3,configuration.set("key", "value");
        *
        * */
        //        配置环境
        Configuration configuration = new Configuration();
        URI uri = URI.create(filePath);
        Path path = new Path(filePath);
        boolean status = false;
        try {
            FileSystem fileSystem = FileSystem.get(uri, configuration);
            status = fileSystem.exists(path);
        } catch (Exception e) {
            System.out.println("fileExistence方法异常！！！");
        }
        return status;

    }
    public static void main(String[] args) {
        String filePath = "hdfs://localhost:9000/user/hadoop/mydata/";
        HdfsClientDemo hdfsClientDemo = new HdfsClientDemo();
        boolean status = hdfsClientDemo.fileExistence(filePath);
        System.out.println(status);
        hdfsClientDemo.uploadFile("/home/hadoop/hello3.txt","hdfs://localhost:9000/user/hadoop/mydata/");
        status = hdfsClientDemo.fileExistence("hdfs://localhost:9000/user/hadoop/mydata/hello3.txt");
        System.out.println(status);
    }
    //    fileSystem方法测试
    FileSystem fileSystem = null;
    @Before
    public void init() throws IOException {
        Configuration configuration = new Configuration();
        fileSystem = FileSystem.get(URI.create("hdfs://localhost:9000/"),configuration);
    }
    @Test
    public void uploadFile(){
        String local = "/home/hadoop/hello2.txt";
        String hdfs = "hdfs://localhost:9000/user/hadoop/mydata/";
        Path localPath = new Path(local);
        Path hdfsPath = new Path(hdfs);
        try {
            fileSystem.copyFromLocalFile(false,true, localPath, hdfsPath);
            fileSystem.close();
            System.out.println("上传文件成功！！！");
        } catch (Exception e) {
            System.out.println("uploadFile方法异常！！！");
        }

    }

    @Test
    public void getFile() throws IOException {
        String hdfs = "mydata/hello3.txt";
        String local = "/home/hadoop/hello3-1.txt";
        Path hdfsPath = new Path(hdfs);
        Path localPath = new Path(local);
        fileSystem.copyToLocalFile(hdfsPath, localPath);
        System.out.println("下载文件成功！！！");
    }

    /*
    * 移动文件
    * */
    @Test
    public void moveFile() throws IOException {
        String fileName1 = "mydata/hello3.txt";
        String fileName2 = "example/hello3-1.txt";
        Path path1 = new Path(fileName1);
        Path path2 = new Path(fileName2);
        boolean status = fileSystem.rename(path1, path2);
        fileSystem.exists(path2);
        fileSystem.close();
        System.out.println(status);
    }

    /*
    * 创建路径
    * */
    @Test
    public void mkdir() throws IOException {
        String dirStr = "example/example1/";
        Path path = new Path(dirStr);
        fileSystem.mkdirs(path);
        boolean status = fileSystem.exists(path);
        System.out.println(status);
        fileSystem.close();

    }

    /*
    * 删除文件
    * */
    @Test
    public void deletePath() throws IOException {
        String pathStr = "example/example1/";
        Path path = new Path(pathStr);
//        true/false设置是否递归删除路径
        fileSystem.delete(path, true);
        boolean status = fileSystem.exists(path);
        System.out.println(status);
        fileSystem.close();
    }

    /*
    * 查询指定目录下的信息
    *
    * */
    @Test
    public void listFiles() throws IOException {
        Path path = new Path("mydata/");
        RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fileSystem.listFiles(path, true);
         while (locatedFileStatusRemoteIterator.hasNext()){
             LocatedFileStatus status = locatedFileStatusRemoteIterator.next();
             System.out.println("路径： "+status.getPath());
             System.out.println("文件长度： "+status.getLen());
             System.out.println("块大小： "+(status.getBlockSize()/(1024*1024))+"M");
             System.out.println("副本数： "+status.getReplication());
             System.out.println("块信息： "+ Arrays.toString(status.getBlockLocations()));
             System.out.println("*********************");
         }
         fileSystem.close();
    }
/*
* 读取文件
* */
    @Test
    public void ReadData() throws IOException {
        Path path = new Path("mydata/hello.txt");
        FSDataInputStream fsDataInputStream = fileSystem.open(path);
//        byte[] bytes = new byte[1024];
//        int num = fsDataInputStream.read(bytes);
//        String str = new String(bytes, 0, num, "utf8");
//        创建缓冲流读取字节信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsDataInputStream, "utf8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null){

            System.out.println(line);
        }
        bufferedReader.close();
        fsDataInputStream.close();
        fileSystem.close();
    }

    /*
    * 写文件
    * */
    @Test
    public void writeFile() throws IOException {
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("mydata/writeTest.txt"));
        fsDataOutputStream.writeBytes("Hello, steve.\nToday is a good day.\n");
        fsDataOutputStream.close();
        fileSystem.close();

    }
}
