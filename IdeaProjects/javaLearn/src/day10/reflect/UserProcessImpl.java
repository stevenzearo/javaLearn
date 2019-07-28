package day10.reflect;

public class UserProcessImpl implements UserProcess {
    private String name = "tom";
    private int age = 22;
    private float wage = 3500f;


    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public void showUserInfo() {
        System.out.println("User: " + name + ", " + age + ", " + wage);
    }
}
