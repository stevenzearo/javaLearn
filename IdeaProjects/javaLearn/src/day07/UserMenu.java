package day07;

import day07.service.UserService;
import day07.service.UserServiceImpl;

import java.util.Scanner;

/*
*
*
* */
public class UserMenu {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1, 登录； 2, 注册; 3, 退出");
            int option = sc.nextInt();
            UserService userManage = new UserServiceImpl();
            switch (option) {
                case 1:
                    System.out.print("请输入用户名：");
                    String userName = sc.next();
                    System.out.print("请输入密码：");
                    String passWord = sc.next();
                    boolean login = userManage.login(userName, passWord);
                    if (login) {
                        System.out.println("登录成功！！！");
                    } else {
                        System.out.println("登录失败！！！ 用户名或密码不正确！！！");
                    }
                    break;
                case 2:
                    System.out.print("请输入用户名：");
                    String name = sc.next();
                    System.out.print("请输入密码：");
                    String passWd1 = sc.next();
                    System.out.print("请确认密码：");
                    String passWd2 = sc.next();
                    int register = userManage.register(name, passWd1, passWd2);
                    switch (register) {
                        case 1:
                            System.out.println("注册成功！！！");
                            break;
                        case 2:
                            System.out.println("注册失败,名字已存在！！！");
                            break;
                        case 3:
                            System.out.println("注册失败,密码不一致！！！");
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;


            }
        }
    }
}
