package test;

import java.util.Scanner;

public class test {
    public static void main(String args[]) {
        float a = 12.2354f;
        String b = String.format("%.2f",a);
        float aa = Float.parseFloat(b);
        System.out.println(aa);
        System.out.println("请输入:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(c);
        System.out.println(d);

        System.out.println(line);
    }
}
