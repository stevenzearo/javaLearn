package day2;

public class MaxValInArray {
    public static void main(String args[]) {
        int ARRAYLENGTH = 10;
        int[] arr = new int[ARRAYLENGTH];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }

        }
        System.out.println("最大值为： " + max);
        System.out.println("最小值为： " + min);
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }
}
