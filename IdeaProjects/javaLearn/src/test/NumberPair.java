package test;

public class NumberPair {
    public int a;
    public int b;
    public int add() {
        int sum = this.a + this.b;
        return sum;
    }
//    无返回值方法
    public void say() {
        System.out.println("Hello, world!");
    }
//    带参数无返回值的方法
    public void sayToSomeone(String name) {
        System.out.printf("Hello, %s!", name);
    }
//    带参数有返回值的方法
    public int addTwoInt(int num1, int num2) {
        return num1 + num2;
    }
    public static void main(String args[]) {
            NumberPair np = new NumberPair();
        np.a = 23;
        np.b = 22;
        System.out.println(np.add());
        np.say();
        np.sayToSomeone("Tom");

    }
}
