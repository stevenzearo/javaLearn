package day10.reflect2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class reflectTest {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/home/hadoop/IdeaProjects/javaLearn/src/day10/reflect2/reflectTest");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String className = bufferedReader.readLine();
//        通过相关字符串信息加载类模板
        Class<?> class1 = Class.forName(className);
//        类的实例化
        User u1 = (User) class1.newInstance();

        String sm1 = bufferedReader.readLine();
        String sm2 = bufferedReader.readLine();
        String sm3 = bufferedReader.readLine();
//        通过相关字符串信息加载方法模板
        Method m1 = class1.getMethod(sm1);
        Method m2 = class1.getMethod(sm2);
        Method m3 = class1.getMethod(sm3, int.class);
//        方法的执行
        String name = (String) m1.invoke(u1);
        System.out.println("name: "+name);
        m2.invoke(u1);
        m3.invoke(u1, 23);
        m2.invoke(u1);

    }

}
