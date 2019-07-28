package day1;

import java.util.Scanner;

public class Computing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String strNum3 = sc.nextLine();
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = Integer.parseInt(strNum3);
        int res = num1 + num2;
        System.out.println(res);
        System.out.println(num3);
    }
}
