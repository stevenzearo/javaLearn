package test;

import dao.impl.UserDaoImpl;
import model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoImplTest {
    UserDaoImpl userDao = null;
    @Before

    public void before(){
        userDao = new UserDaoImpl();

    }

    @Test
    public void test1(){
        int id = 1;
        User user1 = userDao.findUserById(id);
        System.out.println("findUserById: "+user1);

    }

    @Test
    public void test2(){
        List<User> users = userDao.findUsersByName("tom");
        for (User user :
                users) {
            System.out.println("findUsersByName: " + user);
        }
    }

    @Test
    public void test3(){

        boolean status1 = userDao.addUser(new User(3,"jack", 23));
        System.out.println(status1?"信息添加成功！":"信息添加失败！");
    }

    @Test
    public void test4(){
        boolean status2 = userDao.updateUser(new User(6,"scala", 19));
        System.out.println(status2?"信息更新成功！":"信息更新失败！");
    }

    @Test
    public void test5(){
        boolean status3 = userDao.deleteUser(3);
        System.out.println(status3?"信息删除成功！":"信息删除失败！");
    }
}
