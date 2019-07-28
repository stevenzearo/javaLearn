package test;

import java.util.ArrayList;

public abstract class MyFunction {
//    数值型ArrayList排序
    public static void sort(ArrayList<Integer> list, boolean reverse) {
        if (list.size() > 1){
            for (int i = 0; i < list.size()-1; i++) {
                for (int j = 0; j < list.size()-1-i; j++) {
                    int temp = list.get(j+1);
                    if (list.get(j) > list.get(j + 1)) {
                        list.set(j+1, list.get(j));
                        list.set(j, temp);
                    }

                }
                
            }
        }
//        若reverse为true则进行反转操作
        if (reverse){
            ArrayList<Integer> reversedList = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                reversedList.add(list.get(list.size()-1-i));

            }
            for (int i = 0; i < list.size(); i++) {
                list.set(i, reversedList.get(i));

            }
        }

    }

//    遍历并输出ArrayList
    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }

}
