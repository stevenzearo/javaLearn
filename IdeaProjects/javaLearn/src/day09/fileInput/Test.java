package day09.fileInput;

public class Test {
    public static int count(int count){
        if (count != 100){
            count += 1;
            count(count);
        }
        return count;
    }
    public static void main(String[] args){
        int count = 0;
        count = Test.count(count);
        System.out.println(count);
    }

}
