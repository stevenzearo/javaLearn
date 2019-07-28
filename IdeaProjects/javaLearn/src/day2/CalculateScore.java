package day2;

import java.util.Scanner;

public class CalculateScore {
    public static void main(String args[]) {
        int COURSENUM = 5;
        Scanner scn = new Scanner(System.in);
        int sum = 0;

        for (int i = 0; i < COURSENUM; i++) {
            int score = scn.nextInt();
            sum += score;
        }

        System.out.println("总分是： " + sum);
        float average = (float) sum / (float) COURSENUM;
        System.out.printf("平均分是: %.2f\n", average);

    }
}
