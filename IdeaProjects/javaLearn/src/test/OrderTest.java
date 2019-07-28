package test;

import day3.Order;
import day3.Product;
import day3.User;

import java.util.ArrayList;

public class OrderTest {
    public static void main(String args[]) {
        Order order = new Order();
        order.orderId = "0001";
        User user = new User("1001","Tom", "黄金vip");
        order.user = user;
        ArrayList<Product> products = new ArrayList<Product>();
        Product bread = new Product("p0001","bread", 6.5f, 5);
        Product chocolate = new Product("p0002", "chocolate", 12.4f, 3);
        Product milk = new Product("p0003", "milk", 23.9f, 2);
        products.add(bread);
        products.add(chocolate);
        products.add(milk);
        order.products = products;
        order.setAmount();
        order.setPay();
        System.out.println(order.amount);
        System.out.println(order.pay);
    }
}
