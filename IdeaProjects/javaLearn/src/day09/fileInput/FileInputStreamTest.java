package day09.fileInput;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        File myFile = new File("myFileTest.txt");
        FileInputStream stream = new FileInputStream(myFile);
        System.out.println(stream.available());
//        int read;
////        按字节遍历文件,并按字节输出
//        while ((read = stream.read()) != -1){
//            System.out.println((char) read);
//        }
//        按字节遍历文件,输出为字符串
        byte[] bytes = new byte[stream.available()];
        int length;

        while ((length = stream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, length));
        }


    }

}
