package day2;

public class ArraySort {
    public static void main(String args[]) {
        int ARRAYLENGTH = 10;
        int[] arr = new int[ARRAYLENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        System.out.println("*************************************");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                int temp = arr[j+1];
                if (arr[j] > arr[j+1]) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }
}
