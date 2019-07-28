package day10.objectStream;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private float salary;
    private long hairNum;

    public User(){}

    public User(String name, int age, float salary, long hairNum) {

        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hairNum = hairNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getHairNum() {
        return hairNum;
    }

    public void setHairNum(long hairNum) {
        this.hairNum = hairNum;
    }

    @Override
    public String toString() {
        return name+", "+age+", "+salary+", "+hairNum;
    }
}
