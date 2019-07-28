package day6;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String args[]) {
//        构造hashMap对象
        HashMap<String, String> map1 = new HashMap<>();
//        添加数据,key存在则更新value,不存在则创建
        map1.put("p1","Tom");
        map1.put("p2", "John");

//        获取数据
        String a = map1.get("p1");
        System.out.println(a);
//        获取map长度
        System.out.println(map1.size());
//        移除数据
        String v = map1.remove("p1");
        System.out.println(map1.size());
        System.out.println(v);
//        判断key是否存在
        boolean status = map1.containsKey("p1");
        System.out.println(status);
    }
}
