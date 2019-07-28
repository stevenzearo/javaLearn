package day07.ProductManagementSystem.menu;

import day07.ProductManagementSystem.service.Service;
import day07.ProductManagementSystem.service.ServiceImpl;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Service service = new ServiceImpl();
        boolean flag = true;
        while (flag) {
            System.out.println("****欢迎进入商品管理业务系统！！！****");
            System.out.println("*****1，注册；2，登录；3，退出*******");
            System.out.println("*********************************");
            System.out.print("请输入操作指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    System.out.print("请输入id: ");
                    String id = sc.next();
                    boolean existance = service.checkUserExistence(id);
                    if (existance) {
                        System.out.println("id已被注册！！！");
                        break;
                    } else {
                        System.out.print("请输入name: ");
                        String name = sc.next();
                        System.out.print("请输入password: ");
                        String password1 = sc.next();
                        System.out.print("请确认password: ");
                        String password2 = sc.next();
                        if (password1.equals(password2)) {
                            boolean status2 = service.register(id, name, password1);
                            if (status2) {
                                System.out.println("注册成功！！！");
                            } else {
                                System.out.println("注册失败，未知错误！！！");
                            }
                        } else {
                            System.out.println("注册失败，输入的密码前后不一致！！！");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("请输入name: ");
                    String name = sc.next();
                    System.out.print("请输入password: ");
                    String passwrod = sc.next();
                    boolean status3 = service.login(name, passwrod);
                    if (status3) {
                        System.out.println("登陆成功，请进行后续操作！");
                        boolean flag2 = true;
                        while (flag2){
                            System.out.println("***************************");
                            System.out.println("****1，添加商品**************");
                            System.out.println("****2，查看所有商品***********");
                            System.out.println("****3，通过id查看商品*********");
                            System.out.println("****4，利用名字查看商品********");
                            System.out.println("****5，查看价格范围内所有商品***");
                            System.out.println("****6，通过id删除商品*********");
                            System.out.println("****7，返回上层**************");
                            System.out.println("请输入操作指令：");
                            int command2 = sc.nextInt();
                            switch (command2) {
                                case 1:
                                    System.out.print("请输入id: ");
                                    String id1 = sc.next();
                                    System.out.print("请输入name: ");
                                    String name1 = sc.next();
                                    System.out.print("请输入price: ");
                                    float price1 = sc.nextFloat();
                                    System.out.print("请输入quantity: ");
                                    int amount1 = sc.nextInt();
                                    boolean status = service.addProduct(id1, name1, price1, amount1);
                                    if (status) {
                                        System.out.println("添加商品成功！");
                                    } else {
                                        System.out.println("添加商品失败！！！");
                                    }
                                    break;
                                case 2:
                                    service.showAllProducts();
                                    break;
                                case 3:
                                    System.out.print("请输入要查看商品的id: ");
                                    String id2 = sc.next();
                                    service.showProductById(id2);
                                    break;
                                case 4:
                                    System.out.print("请输入要查看商品的name: ");
                                    String name2 = sc.next();
                                    service.showProductByName(name2);
                                    break;
                                case 5:
                                    System.out.print("请输入要查看商品的价格下限: ");
                                    float a = sc.nextFloat();
                                    System.out.print("请输入要查看商品的价格上限: ");
                                    float b = sc.nextFloat();
                                    service.showProductByPriceRange(a, b);
                                    break;
                                case 6:
                                    System.out.print("请输入要删除商品的id: ");
                                    String id3 = sc.next();
                                    boolean status4 = service.removeProductById(id3);
                                    if (status4) {
                                        System.out.println("删除商品成功！");
                                    } else {
                                        System.out.println("删除商品失败！！！");
                                    }
                                    break;
                                case 7:
                                    flag2 = false;
                                    break;
                                default:
                                    break;
                            }

                        }

                    } else {
                        System.out.println("登录失败， 未知错误！！！");
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

}

