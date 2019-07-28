package test;

import day3.Product;

import java.util.ArrayList;

public class ListDemo2 {
    public static void main(String args[]) {
        Product p1 = new Product("0001","bread",5.9f, 3);
        Product p2 = new Product("0002", "cola", 3.5f, 1);
        Product p3 = new Product("0003", "juice", 6.5f, 2);
        ArrayList<Product> arrList = new ArrayList<Product>();
        arrList.add(p1);
        arrList.add(p2);
        arrList.add(p3);
//        计算总金额
        float amount = 0f;
        for (int i = 0; i < arrList.size(); i++) {
            Product product = arrList.get(i);
            amount += product.getAmount();

        }
        System.out.println(amount);
//        计算成交金额最大的商品,及单价最高的商品
        float maxAmount = arrList.get(0).getAmount();
        Product maxAmountProduct = arrList.get(0);
        float maxPrice = arrList.get(0).price;
        Product expensiveProduct = arrList.get(0);
        for (int i = 1; i < arrList.size(); i++) {
            float tempAmount = arrList.get(i).getAmount();
            float tempPrice = arrList.get(i).price;
            if (maxAmount < tempAmount) {
                maxAmountProduct = arrList.get(i);
                maxAmount = tempAmount;

            }
            if (maxPrice < tempPrice) {
                maxPrice = tempPrice;
                expensiveProduct = arrList.get(i);
            }
        }
        System.out.println("maxAmount " + maxAmountProduct.pName + "\t" + maxAmount);
        System.out.println("expensive " + expensiveProduct.pName + "\t" + maxPrice);
//        ArrayList按价格排序
        for (int i = 0; i < arrList.size()-1; i++) {
            for (int j = 0; j < arrList.size()-1-i; j++) {
                Product tempP0 = arrList.get(j+1);
                Product tempP1 = arrList.get(j);
                Product tempP2 = arrList.get(j+1);
                if (tempP1.price > tempP2.price) {
                    arrList.set(j+1, tempP1);
                    arrList.set(j, tempP0);
                }
            }

        }
        System.out.println("*********************");
        for (int i = 0; i < arrList.size(); i++) {
            Product tempP3 = arrList.get(i);
            System.out.println(tempP3.pName + "\t" + tempP3.price);
        }
        System.out.println(p1.toString());
    }
}
