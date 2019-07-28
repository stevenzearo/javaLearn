package day2;

import java.lang.reflect.Array;

public class MergeSort {
    static int[] merge(int[] headArr, int[] endArr){
        int length = headArr.length + endArr.length;
        int[] resultArr =new int[length];
        int flag = 0;
        int i = 0;
        int j = 0;
        while (flag < resultArr.length){
            while (i < headArr.length) {
                while (j < endArr.length) {
                    int tempi = headArr[i];
                    int tempj = endArr[j];
                    if (tempi < tempj) {
                        resultArr[flag] = tempi;
                        i ++;
                    } else {
                        resultArr[flag] = tempj;
                        j ++;
                    }
                    flag += 1;
                }
            }
        }

        return resultArr;
    }
    static int[] sort(int[] arr){
        int[] result = new int[arr.length];
        if (arr.length <= 1) {
            result[0] = arr[0];
            return result;
        } else {
            int mid = arr.length / 2;
            int[] headArr = new int[mid];
            int[] endArr = new int[arr.length-mid];
            for (int i = 0; i < mid; i++) {
                headArr[i] = arr[i];

            }
            for (int i = mid+1; i < arr.length; i++) {
                endArr[i-mid-1] = arr[i];
            }
            int[] sortHead = sort(headArr);
            int[] sortEnd = sort(endArr);
            return merge(sortHead, sortEnd);
        }
    }
    public static void main(String args[]) {
        int LENGTH = 10;
        int[] arr = new int[LENGTH];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        System.out.println("********************");
        int[] sortArr = MergeSort.sort(arr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);

        }
    }
}
