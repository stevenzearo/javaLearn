package hello;

import java.util.Scanner;

public class Hello2 {
    public static void main(String args[]){
        Scanner get_input = new Scanner(System.in);
        float foot=10f;
        float inch=1f;
        System.out.println(foot);
        System.out.print("please input foot:");
        foot = get_input.nextFloat();
        System.out.print("please input inch:");
        inch = get_input.nextFloat();
        System.out.println("standard length is "+((foot+inch/12)*0.3048));
    }
}
