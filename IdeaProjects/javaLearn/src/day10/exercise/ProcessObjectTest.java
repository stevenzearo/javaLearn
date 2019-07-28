package day10.exercise;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ProcessObjectTest {
    public static void main(String[] args) throws Exception {
//        读取存储的商品
        ProcessObject<Product> productReadObject = new ProcessObject<>();
        ArrayList<Product> products = productReadObject.readObject("pdt.obj", 4);
//        读取存储的订单
        ProcessObject<Order> orderReadObject = new ProcessObject<>();
        ArrayList<Order> orders = orderReadObject.readObject("order.obj", 4);
//        生成商品id和商品对象的HashMap
        HashMap<String, Product> productHashMap = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            productHashMap.put(products.get(i).getpId(), products.get(i));
        }
//        生成订单id和订单详情对象的HashMap
        HashMap<String, OrderDetail> orderDetailHashMap = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            Order tempOrder = orders.get(i);
            OrderDetail value = null;
            String key = tempOrder.getOrderId();
            Product tempProduct = productHashMap.get(tempOrder.getPdtId());
            if (orderDetailHashMap.containsKey(key)){
                value = orderDetailHashMap.get(key);
            } else {
                value = new OrderDetail();
            }
            value.setOrderId(tempOrder.getOrderId());
            int num = tempOrder.getPdtNum();
            value.addProduct(tempProduct, num);
            orderDetailHashMap.put(key, value);

        }
//        存储orderDetail对象到本地
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("order_detail.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (OrderDetail tempOrderDetail : orderDetailHashMap.values()
            ) {
                System.out.println(tempOrderDetail);
                objectOutputStream.writeObject(tempOrderDetail);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Finished!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
