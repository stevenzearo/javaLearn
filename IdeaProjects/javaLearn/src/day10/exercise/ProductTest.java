package day10.exercise;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("p01","香蕉",10.8f);
        Product p2 = new Product("p02","苹果",10.8f);
        Product p3 = new Product("p03","榴莲",28.8f);
        Product p4 = new Product("p04","葡萄",18.8f);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("pdt.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
            objectOutputStream.writeObject(p3);
            objectOutputStream.writeObject(p4);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("finished!!!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
