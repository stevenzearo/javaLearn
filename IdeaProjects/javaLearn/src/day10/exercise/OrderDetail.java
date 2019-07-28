package day10.exercise;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderDetail implements Serializable {
    private String orderId = null;
    private HashMap<Product, Integer> products = new HashMap<>();
    private float amount = 0;

    public OrderDetail() {
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public HashMap<Product, Integer> getProducts() {
        return this.products;
    }

    public void setProducts(final HashMap<Product, Integer> products) {
        this.products = products;
        for (Map.Entry<Product, Integer> entry: products.entrySet()
             ) {
            Product product = entry.getKey();
            amount = product.getpPrice()*entry.getValue();
        }
    }

    public float getAmount() {
        return this.amount;
    }
    public void addProduct(Product product, int num){
        if (products.containsKey(product)){
            int tempNum = products.get(product);
            tempNum += num;
            products.put(product, tempNum);
        } else {
            products.put(product, num);
        }
        amount += product.getpPrice()*num;
    }
    public void showProducts(){
        for (Map.Entry<Product, Integer> entry: products.entrySet()
             ) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        String subs = "\n";
        for (Map.Entry<Product, Integer> entry: products.entrySet()
             ) {
            subs += (entry.getKey() + " | " + entry.getValue() + "\n");
        }
        return "OrderDetail:\n" + orderId + subs + amount;
    }
}
