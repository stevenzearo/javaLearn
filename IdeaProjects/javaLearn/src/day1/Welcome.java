package day1;

import java.util.Scanner;

/**
 * @author hadoop
 */
public class Welcome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine().trim();

        if (user.equals("tom")) {
            System.out.println("hello, " + user);
        } else if (user.equals("jim")){
            System.out.println("welcome, " + user);
        } else {
            System.out.println("sorry permission denied");
        }
    }
}
