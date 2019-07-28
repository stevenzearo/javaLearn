package day2;

import java.util.Scanner;

public class Student {

        String name;
        int number;
        int age;
        float score;
        void setInfo() {
            Scanner scn = new Scanner(System.in);
            System.out.print("name: ");
            name = scn.nextLine();
            System.out.print("number: ");
            number = scn.nextInt();
            System.out.print("age: ");
            age = scn.nextInt();
            System.out.print("score: ");
            score = scn.nextFloat();
        }
}
