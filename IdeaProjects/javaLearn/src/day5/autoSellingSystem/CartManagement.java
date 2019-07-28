package day5.autoSellingSystem;

import java.util.ArrayList;

public class CartManagement {
    private ArrayList<Product> cart = new ArrayList<Product>();
//    添加商品
    public boolean addProduct(Product product, ArrayList<Product> productsInStore) {
//        要添加的商品是否在购物车中，默认为不在购物车中
        boolean flag = false;
//        添加商品到购物车中是否成功，默认为添加不成功
        boolean status = false;
//        将要添加的商品数
        int updateNumber = 0;
        int position = 0;
//        判断商品是否在购物车中并记录商品所在位置
        for (int i = 0; i < cart.size(); i++) {
            Product productInCart = cart.get(i);
            if (productInCart.getId().equals(product.getId())) {
                updateNumber = productInCart.getNumber() + product.getNumber();
                flag = true;
                position = i;
                break;
            }
        }
        if (!flag) {
            updateNumber = product.getNumber();
        }
//        判断是否能够成功添加商品
        for (int i = 0; i < productsInStore.size(); i++) {
            if (product.getId().equals(productsInStore.get(i).getId())) {
                int maxNumber = productsInStore.get(i).getNumber();
                if (updateNumber <= maxNumber) {
                    status = true;
                }
            }
        }
//        更新要添加的商品的数量
        product.setNumber(updateNumber);
//        添加商品到购物车
        if (flag) {
            cart.set(position,product);
        } else {
            cart.add(product);
        }
        return status;
    }
//    移除商品
    public void removeProduct(Product product){
        cart.remove(product);

    }
//    打印购物车信息
    public void showCartInfo(){
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));

        }

    }
//    修改购物车信息
    public void amendCartInfo(Product product){

        for (int i = 0; i < cart.size(); i++) {
            Product productInCart = cart.get(i);
            if (product.getName().equals(productInCart.getName())) {
                productInCart.setNumber(product.getNumber());
                cart.set(i, productInCart);
                break;
            }
        }
    }
}