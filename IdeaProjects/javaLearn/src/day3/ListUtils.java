package day3;

import java.util.ArrayList;

public abstract class ListUtils {
//    排序
    public static void sort(ArrayList<Integer> list, boolean reverse) {
        if (list.size() > 1){
            for (int i = 0; i < list.size()-1; i++) {
                for (int j = 0; j < list.size()-1-i; j++) {
                    int temp = list.get(j+1);
                    if (list.get(j) > list.get(j+1)) {
                        list.set(j+1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
            if (reverse) {
                ArrayList<Integer> reversedList = new ArrayList<Integer>();
                for (int i = 0; i < list.size(); i++) {
                    reversedList.add(list.get(list.size()-1-i));

                }
                for (int i = 0; i < reversedList.size(); i++) {
                    list.set(i, reversedList.get(i));

                }
            }
        }
    }
//    求最大值
    public static int max(ArrayList<Integer> list) {
        int max = list.get(0);
        if (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }

            }
        }
        return max;
    }
//    求最小值
    public static int min(ArrayList<Integer> list) {
        int min = list.get(0);
        if (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                }

            }
        }
        return min;
    }
//    求均值
    public static float mean(ArrayList<Integer> list) {
        float mean;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);

        }
        mean = (float) sum / (float) list.size();
        return mean;
    }
}
