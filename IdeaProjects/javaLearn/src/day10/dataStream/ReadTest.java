package day10.dataStream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadTest {
public static void main(String[] args){
    try {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        for (int i = 0; i < 3; i++) {
            User tempUser = new User();
            tempUser.setName(dataInputStream.readUTF());
            tempUser.setAge(dataInputStream.readInt());
            tempUser.setSalary(dataInputStream.readFloat());
            tempUser.setHairNum(dataInputStream.readLong());
            System.out.println(tempUser.toString());
        }
        dataInputStream.close();
        fileInputStream.close();
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
