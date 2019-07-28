package day1;

import java.util.Scanner;

public class GuessValueWhile {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean status = false;
//        设置最大执行次数
        int i = 6;
        while (!status) {
//            循环获取用户输入
            int num = sc.nextInt();
//            比较输入值与内置值
            if (num > 8) {
                System.out.println("大了");
            } else if (num < 8) {
                System.out.println("小了");
            } else {
                System.out.println("对了");
                status = true;
            }
            i --;
            if (i == 0) break;
    }
    }
}
