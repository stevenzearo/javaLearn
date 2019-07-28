package hello;

import java.util.Scanner;

public class Hello3 {
    public static void main(String args[]){
        Scanner get_input = new Scanner(System.in);
        String s = "hello";
        System.out.print("请输入字符串： ");
        String in = get_input.next();
        System.out.println("the length of input is " + s.length());
        System.out.print("s is in: ");
        System.out.println(s == in);
        System.out.print("s is equal to in: ");
        System.out.println(in.equals(s));
        for (int i = 0; i < s.length(); i++){

            System.out.println(in.charAt(i));
        }
        }
    }
