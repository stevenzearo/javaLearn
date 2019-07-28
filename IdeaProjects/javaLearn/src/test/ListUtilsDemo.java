package test;

import day3.ListUtils;

import java.util.ArrayList;

public class ListUtilsDemo {
    public static void main(String args[]) {
        int LENGTH = 10;
//        产生随机整数列表
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < LENGTH; i++) {
            intList.add(i, (int)(Math.random()*100));
        }
//        排序并反转（由大到小排序）
        ListUtils.sort(intList, true);
        System.out.println(intList.toString());
//        求最大值
        int max = ListUtils.max(intList);
//        求最小值
        int min = ListUtils.min(intList);
//        求均值
        float mean = ListUtils.mean(intList);
        System.out.println("max"+"\t"+"min"+"\t"+"mean");
        System.out.println(max+"\t"+min+"\t"+mean);
    }
}
