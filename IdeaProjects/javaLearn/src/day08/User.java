package day08;

public class User implements Comparable<User>{
    private String id;
    private String name;
    private int age;
    private float wage;

    public User() {
    }
    public User(String id, String name, int age, float wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWage() {
        return this.wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+age+", "+wage;
    }

    @Override
    public int compareTo(User o) {
        int status = 0;
        if (this.getAge() > o.getAge()) {
            status = 1;
        } else{
            status = -1;
        }
        return status;
    }
}
