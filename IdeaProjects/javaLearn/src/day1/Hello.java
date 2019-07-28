package day1;

import java.util.Scanner;

public class Hello {
    public static void main(String args[]) {
        System.out.println("Hello, world!");
        Scanner sc = new Scanner(System.in);
        System.out.print("please input:");
        String in = sc.nextLine();
        System.out.println("your input: "+in);

    }
}