package test;

import java.util.ArrayList;

/*
 * 测试ArrayList的用法
 * <>中填入范型参数
 * ArrayList是一种集合类型，可以装任意多个具体的数据，而且长度可变
 * 重要功能：
 *      add()追加
 *      get()读取
 *      remove()移除
 * @author hadoop
 * */

public class ListDemo {
    public static void main(String args[]) {
//        创建装整数的ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>();
//        添加数据
        arr.add(123);
        arr.add(223);
        arr.add(323);
//        读取数据
        System.out.println(arr.get(0));
//        遍历
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println("**************");
//        移除
        arr.remove(0);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));

        }
    }
}
