package day07.basicTest1;

import java.util.*;

public class BaseTest {
    public static void main(String[] args) {
//        生成随机数组
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random()*100);
        }

        System.out.println("********顺序遍历ints*********");
//        顺序遍历
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


        System.out.println("**********反序遍历ints********");
//        反序遍历
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[ints.length-1-i]);

        }

//        生成随机ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int)(Math.random()*100));

        }
        System.out.println("*********顺序遍历ArrayList********");
//        顺序遍历ArrayList
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));

        }
        System.out.println("********反序遍历ArrayList********");
//        反序遍历ArrayList
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(arrayList.size()-1-i));

        }

//        创建Set并添加数据
        Set<String> set = new HashSet<>();
        set.add("Today");
        set.add("is");
        set.add("definitely");
        set.add("good");
        set.add("day");
        System.out.println("*******遍历Set*******");
//        遍历Set
        for (String temp: set
             ) {
            System.out.println(temp);
        }

//        生成HashMap
        HashMap<String, Integer> map = new HashMap<>();
//        按条件添加key-value
        map.put("a",1);
        map.put("b",3);
        map.put("c",2);
        map.put("d",6);
        map.put("e",7);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        System.out.println("**********按条件遍历map**********");
//        按条件遍历map
        for (Map.Entry<String, Integer> ent: entrySet
             ) {
            if (ent.getValue() % 2 == 1) {
                System.out.println(ent.getKey()+" | "+ent.getValue());
            }
        }

    }
}
