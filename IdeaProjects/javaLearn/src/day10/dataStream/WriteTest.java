package day10.dataStream;

import org.omg.CORBA.DataInputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteTest {
    public static void main(String[] args){
        User user1 = new User("tom", 23, 4303.25f, (long) Math.pow(2,24));
        System.out.println((long) Math.pow(2,24));
        User user2 = new User("john", 22, 4123.38f, (long) Math.pow(2,21));
        System.out.println((long) Math.pow(2,21));
        User user3 = new User("adam", 21, 3455.67f, (long) Math.pow(2,22));
        System.out.println((long) Math.pow(2,22));
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            for (int i = 0; i < arrayList.size(); i++) {
                User tempUser = arrayList.get(i);
                dataOutputStream.writeUTF(tempUser.getName());
                dataOutputStream.writeInt(tempUser.getAge());
                dataOutputStream.writeFloat(tempUser.getSalary());
                dataOutputStream.writeLong(tempUser.getHairNum());
            }
            dataOutputStream.close();
            fileOutputStream.close();
            System.out.println("finished!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
