package day10.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order("o1", "p01", 3);
        Order o2 = new Order("o1", "p04", 2);
        Order o3 = new Order("o2", "p02", 5);
        Order o4 = new Order("o2", "p03", 2);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("order.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o1);
            objectOutputStream.writeObject(o2);
            objectOutputStream.writeObject(o3);
            objectOutputStream.writeObject(o4);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Finished");
            FileInputStream fileInputStream = new FileInputStream("order.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Order> objects = new ArrayList<>();
            for (int i = 0; i < 4; i++){

                Order t = (Order) objectInputStream.readObject();
                System.out.println(t);
                objects.add(t);
            }
            objectInputStream.close();
            fileInputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
