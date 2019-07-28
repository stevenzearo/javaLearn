package day10.objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
    public static void main(String[] args) throws Exception{
        User user1 = new User("tom", 23, 4303.25f, (long) Math.pow(2,24));
        User user2 = new User("john", 22, 4123.38f, (long) Math.pow(2,21));
        User user3 = new User("adam", 21, 3455.67f, (long) Math.pow(2,22));
        FileOutputStream fileOutputStream = new FileOutputStream("objectStreamTest.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user1);
        objectOutputStream.writeObject(user2);
        objectOutputStream.writeObject(user3);
        objectOutputStream.close();
        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("objectStreamTest.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        for (int i = 0; i < 3; i++) {

            User object = (User)objectInputStream.readObject();
            System.out.println(object);
        }
        objectInputStream.close();
        fileInputStream.close();

    }

}
