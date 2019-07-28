package day10.dataStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamTest {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("dataOutputStreamTest.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        for (int i = 0; i < 10; i++) {
            int num = (int)(Math.random()*100);
            System.out.println(num);
            dataOutputStream.writeInt(num);
        }
        dataOutputStream.close();
    }

}
