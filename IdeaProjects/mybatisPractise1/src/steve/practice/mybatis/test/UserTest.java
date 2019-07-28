package steve.practice.mybatis.test;

import org.junit.Test;
import steve.practice.mybatis.model.User;
import steve.practice.mybatis.service.UserService;
import steve.practice.mybatis.serviceImpl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class UserTest {

    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input name: ");
        String name = scanner.nextLine();
        System.out.println("please input password: ");
        String password = scanner.nextLine();
        UserServiceImpl userService = new UserServiceImpl();
        User userIn = new User();
        userIn.setName(name);
        userIn.setPassword(password);
        User user = userService.findUserByUserNameAndPassword(userIn);
        if (user != null){
            System.out.printf("hello %s, welcome to login......", user.getName());
        } else {
            System.out.println("failed to login!!!");
        }

    }
    @Test
    public void findUsersAndOrders(){
        UserService service = new UserServiceImpl();
        List<User> users = service.findUsersAndOrders();
        for (User user :
                users) {
            System.out.println(user);
        }

    }

    public static void main(String[] args) {
        UserTest.test1();
    }
}
