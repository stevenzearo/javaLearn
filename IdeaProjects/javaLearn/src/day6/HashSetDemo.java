package day6;

import java.util.HashSet;
import java.util.Iterator;

/*
*
* HashSet集合数据类型,可装入多个数据
* 数据不重复
* 数据是无序的（存入的数据与保存的的顺序不一致）
*
* */
public class HashSetDemo {
    public static void main(String args[]) {
        HashSet<String> set1 = new HashSet<>();

        set1.add("tom");
        set1.add("john");
        set1.add("tom");
        set1.add("adam");

        int size = set1.size();
        System.out.println(size);

        set1.remove("tom");
        System.out.println(set1.size());
        Iterator<String> iterator = set1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*******************");
//        增强for循环,内部封装了迭代器(主要用于遍历可以装多个数据的容器)
        for (String temp: set1) {
            System.out.println(temp);
        }
        System.out.println("*******************");
        int[] arr = new int[10];
        for (int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*100);
        }
        for (int num: arr) {
            System.out.println(num);
        }
    }
}
