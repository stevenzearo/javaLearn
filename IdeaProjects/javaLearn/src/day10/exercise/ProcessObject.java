package day10.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProcessObject<T> {
//    读取存储object的文件
    public ArrayList<T> readObject(String fileName, int objectNum) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList<T> objects = new ArrayList<>();
        for (int i = 0; i < objectNum; i++){

            objects.add((T) objectInputStream.readObject());
        }
        objectInputStream.close();
        fileInputStream.close();
        return objects;
    }
}
