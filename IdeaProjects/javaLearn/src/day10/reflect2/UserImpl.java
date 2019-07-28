package day10.reflect2;

public class UserImpl implements User {

    private String name = "john";
    private int age = 22;
    private float hight = 1.73f;

    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public void showUserInfo() {
        System.out.println("User: "+name+", "+age+", "+hight);
    }

    @Override
    public void setUserAge(int age) {
        this.age = age;
    }
}
