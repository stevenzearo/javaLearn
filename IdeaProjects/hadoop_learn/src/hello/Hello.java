package hello;

import java.util.Scanner;

public class Hello {
    public static void main(String args[]){
        System.out.println("Hello, world!");
        Scanner getInput = new Scanner(System.in);
//        System.out.println("Steve: "+getInput.nextLine());
        int num = 0;
        int amount = 100;
        System.out.print("please input first number:");
        amount = getInput.nextInt();
        System.out.print("please input second number:");
        num = getInput.nextInt();
        System.out.println(amount+"+"+num+"="+(amount+num));
    }
}
