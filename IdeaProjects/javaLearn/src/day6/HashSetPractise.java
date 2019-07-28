package day6;

import java.util.*;

public class HashSetPractise {
    public static void main(String args[]) {
        int[] arr = new int[12];
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*10);
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set1.add(arr[i]);

        }
        for (int temp: set1) {
            map1.put(temp, 0);
            System.out.println(temp);
        }
        for (int i = 0; i < arr.length; i++) {
            int time = map1.get(arr[i]);
            map1.put(arr[i], time+=1);
        }
        Set<Integer> set2 = map1.keySet();
        int sum = 0;
        for (int temp: set2) {
            int times = map1.get(temp);
            sum += times;
            System.out.println(temp+"|"+times );
        }
        System.out.println(sum);
    }
}
