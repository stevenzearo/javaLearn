package day09.fileOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileOutputTest {
    public static void main(String[] args) throws Exception{
        File myFile = new File("myFileOutputTest.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(myFile, false);
//        上一行true参数表示追加
//        fileOutputStream.write("hello".getBytes());
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (int i = 0; i < 3; i++) {

            bufferedWriter.write("today is a good day");
            bufferedWriter.newLine();
        }
//        bufferedWriter必须关闭
        bufferedWriter.close();
        fileOutputStream.close();

    }

}
