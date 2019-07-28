package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDeom {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classPath = "test.MyUser";
        String methodName = "say";
//        创建类模板
        Class<?> className = Class.forName(classPath);
//        创建类的实例
        MyUser myUser = (MyUser) className.newInstance();
        System.out.println(myUser);
//        创建类的方法模板
        Method method = className.getMethod(methodName,String.class);
//        传入方法执行的对象和参数
        method.invoke(myUser,"tom");

    }

}
