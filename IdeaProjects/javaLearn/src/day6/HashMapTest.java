package day6;

import day5.autoSellingSystem.Product;

import java.util.*;

public class HashMapTest {
        public static void main(String args[]){
            Product p1 = new Product("1", "香蕉", "fruit", 2.6f, 20);
            Product p2 = new Product("2", "苹果", "fruit", 8.4f, 12);
            Product p3 = new Product("3", "橘子", "fruit", 3.5f, 23);
            Product p4 = new Product("4", "梨", "fruit", 4.3f, 13);
            Product p5 = new Product("5", "梨", "fruit", 4.3f, 13);
            Product p6 = new Product("6", "苹果", "fruit", 8.4f, 12);
            Product p7 = new Product("7", "苹果", "fruit", 8.4f, 12);

            HashMap<String, Product> pdtMap = new HashMap<>();
            pdtMap.put(p1.getId(), p1);
            pdtMap.put(p2.getId(), p2);
            pdtMap.put(p3.getId(), p3);
            pdtMap.put(p4.getId(), p4);
            pdtMap.put(p5.getId(), p5);
            pdtMap.put(p6.getId(), p6);
            pdtMap.put(p7.getId(), p7);

            HashMap<String, Product> pdtMap2 = new HashMap<>();
            pdtMap2.put(p1.getName(), p1);
            pdtMap2.put(p2.getName(), p2);
            pdtMap2.put(p3.getName(), p3);
            pdtMap2.put(p4.getName(), p4);
            pdtMap2.put(p5.getName(), p5);
            pdtMap2.put(p6.getName(), p6);
            pdtMap2.put(p7.getName(), p7);

            HashMap<String, String> idAndNameMap = new HashMap<>();
        for (Product pdt: pdtMap.values()) {
            if (idAndNameMap.containsKey(pdt.getName())){
                String newValue = pdt.getId() + " | " + idAndNameMap.get(pdt.getName());
                idAndNameMap.put(pdt.getName(), newValue);

            } else {
                idAndNameMap.put(pdt.getName(),pdt.getId());
            }
        }
            System.out.println(idAndNameMap);
    }
}
