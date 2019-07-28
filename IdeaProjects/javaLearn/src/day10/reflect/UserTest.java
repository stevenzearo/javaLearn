package day10.reflect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class UserTest {
    public static void main(String[] args) throws Exception{
//        UserProcessImpl userProcess1 = new UserProcessImpl();
//        userProcess1.showUserInfo();
        FileInputStream fileInputStream = new FileInputStream("/home/hadoop/IdeaProjects/javaLearn/src/day10/reflect/className");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String className = bufferedReader.readLine().split("=")[1].trim();

        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        Class<?> user = Class.forName(className);
        UserProcess userProcess = (UserProcess) user.newInstance();
        String name = userProcess.getUserName();
        System.out.println(name);
        System.out.println("*****************");
        userProcess.showUserInfo();
    }

}
