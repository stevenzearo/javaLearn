package day10.dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamTest {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("dataOutputStreamTest.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int num;
        for (int i = 0; i < 10; i++) {
            System.out.println(dataInputStream.readInt());

        }
        dataInputStream.close();
//        while ((num = dataInputStream.readInt())!= -1){
//
//        }
    }

}
