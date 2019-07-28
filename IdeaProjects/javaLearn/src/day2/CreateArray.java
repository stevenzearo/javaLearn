package day2;
/*
*数组示例,遍历数组
*
* */

public class CreateArray {
    public static void main(String args[]) {
        int ARRAYLENGTH = 11;
        int[] intArr = new int[ARRAYLENGTH];
        for (int i = 0; i < ARRAYLENGTH; i++) {
            intArr[i] = i;

        }

        for (int i = intArr.length; i > 0; i--) {
            System.out.println(intArr[i-1]);

        }
    }
}
