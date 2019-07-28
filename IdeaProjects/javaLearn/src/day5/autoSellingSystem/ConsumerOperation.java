package day5.autoSellingSystem;

import java.util.ArrayList;

/*
* 购买操作
* */
public abstract class ConsumerOperation {
//    获取用户购买商品相关信息
    public static Product getProduct(String productId, int number,
                                     ArrayList<Product> productsInStore){
        Product reProduct = new Product();
        for (int i = 0; i < productsInStore.size(); i++) {
            Product product = productsInStore.get(i);
            if (product.getId().equals(productId)){
//                返回值的属性设置
                reProduct.setId(product.getId());
                reProduct.setName(product.getName());
                reProduct.setCategory(product.getCategory());
                reProduct.setNumber(number);
                break;
            }

        }
        return reProduct;
    }
//    回到主界面
    public static boolean goHome(int num) {
        boolean flag = false;
        if (num == 1) {
            flag = true;
        }
        return flag;
    }
    public static ArrayList<Product> submitOrder(){
        return null;
    }
}
