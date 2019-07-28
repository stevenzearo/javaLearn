package day2;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {

    public static void main(String args[]) {
        int NUMBER = 5;
        Student[] stuList = new Student[NUMBER];
        for (int i = 0; i < NUMBER; i++) {
            Student stu = new Student();
            stu.setInfo();
            stuList[i] = stu;

        }
        for (int i = 0; i < stuList.length-1; i++) {
            for (int j = 0; j < stuList.length-1-i; j++) {
                Student member1 = stuList[j];
                Student member2 = stuList[j+1];
                Student temp = stuList[j+1];
                if (member1.score > member2.score){
                    stuList[j+1] = member1;
                    stuList[j] = temp;
                }
            }
        }
        for (int i = 0; i < stuList.length; i++) {
            System.out.println(stuList[i].score);
        }
    }
}
