package day2;

import java.util.Scanner;

public class CalculateScore2 {
    public static void main(String args[]) {
        int COURSENUM = 5;
        Scanner scn = new Scanner(System.in);
        float[] scoresArr = new float[5];

        for (int i = 0; i < COURSENUM; i++) {
            scoresArr[i] = scn.nextFloat();
        }
        int sum = 0;

        for (int i = 0; i < scoresArr.length; i++) {
            sum += scoresArr[i];
        }

        float average = sum / (float)COURSENUM;
        System.out.printf("总成绩是： %.2f\n", sum);

        System.out.printf("平均分是： %.2f\n", average);
    }
}
