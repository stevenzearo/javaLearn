package day1;

import java.util.Scanner;

public class GuessValueFor {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int DEFAULT = 8;
        for (int i = 0; i < 8; i++) {
            int num = sc.nextInt();
            if (num > DEFAULT){
                System.out.println("大了");
            } else if (num < DEFAULT){
                System.out.println("小了");
            } else {
                System.out.println("你猜对了");
                break;
            }

        }
    }
}
