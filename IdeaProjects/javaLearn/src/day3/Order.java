package day3;

import java.util.ArrayList;

/*
* 订单类
* 订单ID
* 订单所属用户
* 订单所包含商品
* 订单应付金额
* 订单总金额
* */
public class Order {
    public String orderId;
    public User user;
    public ArrayList<Product> products;
    public float amount;
    public float pay;
    public void setAmount(){
        float sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getAmount();
        }
        amount = sum;
    }
    public void setPay(){
        float basicCount;
        float extralCount;
        if (amount >= 1000 && amount < 2000){
            basicCount = 0.98f;
        } else if (amount >= 2000 && amount < 3000) {
            basicCount = 0.95f;
        } else if (amount >= 3000) {
            basicCount = 0.9f;
        } else {
            basicCount = 1f;
        }
        if (user.vipLevel.equals("黄金vip")) {
            extralCount = 0.98f;
        } else if (user.vipLevel.equals("钻石vip")) {
            extralCount = 0.96f;
        } else if (user.vipLevel.equals("至尊vip")) {
            extralCount = 0.92f;
        } else {
            extralCount = 1f;
        }
        pay = amount*basicCount*extralCount;

    }

}
