package learn.classAndObject;

public class Circle {
    float radius,perimeter,area;
    final float PI = (float) 3.14159265;
    Circle(float r) {
        radius = r;
        perimeter = 2*PI*r;
        area = PI*r*r;
    }
    void showCircle(){
        System.out.printf("半径：%06.2f;周长：%06.2f；面积：%06.2f\n",radius,perimeter,area);
    }
    public static void main(String args[]) {
        float r = 1.2f;
        Circle cir = new Circle(r);
        cir.showCircle();
        System.out.println(Float.MAX_VALUE);
    }
}
