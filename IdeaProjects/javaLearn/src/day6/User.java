package day6;

import java.util.*;

public class User {
    private String id;
    private String name;
    private String password;
    private String phone;
    private int wage = 0;
    private int age = 0;
    public User(){}
    public User(String id, String name, String password, String phone, int wage, int age){
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.wage = wage;
        this.age = age;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + password + " | " + phone + " | " + wage + " | " + age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getWage() {
        return wage;
    }

    public int getAge() {
        return age;
    }


}
