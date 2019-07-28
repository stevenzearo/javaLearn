package day5.autoSellingSystem;

import java.util.ArrayList;
import java.util.Scanner;

/*
* 自动售货系统入口程序
* */
public class Menu {

    public static void main(String args[]) {
//        向系统中添加商品
        SellerOperation.addProducts();
//        获取商品列表
        ArrayList<Product> products = ProductManagement.getProducts();
//        创建购物车
        CartManagement cart = new CartManagement();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("************************************");
            System.out.println("欢迎进入自动售货系统,请选择要进行的操作!");
            System.out.print("1,浏览所有商品 | ");
            System.out.print("2,购物 | ");
            System.out.print("3,查看购物车 | ");
            System.out.print("4,修改购物车 | ");
            System.out.print("5,提交订单 | ");
            System.out.print("6,付款 | ");
            System.out.print("7,退出\n");
            System.out.println("************************************");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    ProductManagement.showProducts();
                    break;
                case 2:
                    boolean flag2;
                    do {
                        String productId;
                        boolean status;
                        System.out.print("请输入购买的商品id:");
                        productId = sc.next();
                        System.out.print("请输入购买的数量:");
                        int number = sc.nextInt();
                        Product productBuy = ConsumerOperation.getProduct(productId,number,products);
                        status = cart.addProduct(productBuy,products);
                        if (status) {
                            System.out.println("成功添加商品到购物车！");
                            ProductManagement.updateProductFromCart(productBuy);
                        } else {
                            System.out.println("很遗憾,添加商品失败！店长正在努力添加库存。。。");
                        }
                        System.out.println("继续购买请输入1,返回上层请输入2");
                        int temp = sc.nextInt();
                        flag2 = ConsumerOperation.goHome(temp);
                    } while (flag2);
                    break;
                case 3:
                    cart.showCartInfo();
                    break;
                case 4:
                    cart.amendCartInfo(new Product());
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("请输入正确指令!");
                    break;

            }

        }

    }
}
