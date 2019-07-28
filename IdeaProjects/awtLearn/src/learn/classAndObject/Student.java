package learn.classAndObject;

public class Student {
    private int id;
    private String name;
    private int score;
    private static float pay;
    //静态(static)属性作用,在实例创建之前为静态属性或方法分配内存使之能够被调用
    private static void setPay(float pay){
        Student.pay = pay;
    }
    Student(int id, String name, int score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
    void showScore(){
        System.out.printf("id:%06d\tname:%s\tscore:%d/100\n",id,name,score);
    }
    public static void main(String args[]) {
        Student.pay = 400;
        System.out.println(Student.pay);
        Student.setPay(300);
        System.out.println(Student.pay);
        Student tom = new Student(123,"tom",89);
        tom.showScore();
        tom.pay = 300f;
        System.out.printf("%s's aid is %.2f\n",tom.name,tom.pay);
        tom.pay = 200;
        System.out.printf("%.2f", Student.pay);
    }
}
