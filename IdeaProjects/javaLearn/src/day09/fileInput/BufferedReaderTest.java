package day09.fileInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception{
        File myFile = new File("myFileTest.txt");
//        创建流,读取文件的基础
        FileInputStream stream = new FileInputStream(myFile);
//        创建文件流读取器,可设置编码格式
        InputStreamReader reader = new InputStreamReader(stream, "utf8");
//        创建缓冲读取器
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s;
        while ((s = bufferedReader.readLine()) != null){
            System.out.println(s);
        }
        stream.close();

    }

}
