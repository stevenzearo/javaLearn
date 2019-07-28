package day5.autoSellingSystem;

import java.util.ArrayList;

/*
 * 此类功能
 * 1,保存所有的商品数据
 * 2.提供操作这些数据的方法
 *
 * */
public class ProductManagement {

    private static ArrayList<Product> products = new ArrayList<Product>();

    /*
    * 添加商品
    * */
    public static void addProduct(Product product) {
        products.add(product);
    }

    public  static ArrayList<Product> getProducts() {
        return products;
    }
    /*
    * 移除商品
    * */
    public static void removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())) {
                products.remove(i);
            }
        }
    }
    /*
    * 打印商品
    * */
    public static void showProducts(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));

        }
    }
    /*
    * 更新商品数量信息
    * */
    public static void updateProductFromCart(Product productFromCart){
        int updateNumber;

        for (int i = 0; i < products.size(); i++) {
            Product productInStore = products.get(i);
            if (productInStore.getId().equals(productFromCart.getId())){
                int remainNumber = productInStore.getNumber();
//                添加到购物车的数量
                int cartNumber = productFromCart.getNumber();
                updateNumber = remainNumber - cartNumber;
//                库存数量更新
//                注：引用对象的属性的改变会导致所有引用该对象的相关变量的属性同时改变
                productInStore.setNumber(updateNumber);
                break;
            }
        }

    }
}
