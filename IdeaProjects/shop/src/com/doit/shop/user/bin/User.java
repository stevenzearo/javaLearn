package com.doit.shop.user.bin;

/*
* 描述用户信息的实体类
* */
public class User {
    private String account;
    private String name;
    private String password;
    private int age;
    private String phone;
    private int vipLevel;

    public User() {
    }

    public User(String account, String name, String password, int age, String phone, int vipLevel) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.vipLevel = vipLevel;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Override
    public String toString() {
        return "User: "+account+", "+name+", "+password+", "+age+", "+phone+", "+vipLevel;
    }
}
