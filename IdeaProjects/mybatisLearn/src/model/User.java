package model;

public class User {
//    属性名需要同表的列名相同
    int id;
    String uname;
    int age;

//    必须要有一个空参构造方法，否则会有异常
    public User(){}
    public User(String uname, int age){
        this.uname = uname;
        this.age = age;

    }
    public User(int id, String uname, int age){
        this.id = id;
        this.uname = uname;
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: "+id+", "+uname+", "+age;
    }
}
