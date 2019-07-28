package day13.socketLearn;

public class Test {
    public static void main(String[] args) {
        byte[] b = new byte[1024];
        for (int i = 79; i < 89; i++) {
            b[i-79] = (byte) i;
        }
        String s = new String(b,5,8);
        System.out.println(s);
    }

}
