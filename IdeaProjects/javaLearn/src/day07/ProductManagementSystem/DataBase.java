package day07.ProductManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
private static HashMap<String, User> users = new HashMap<>();
private static HashMap<String, Product> products = new HashMap<>();

    public DataBase() {
    }
    public static HashMap<String, User> getUsers() {
        return DataBase.users;
    }
    public static User getUserById(String id){
        User user = null;
        if (users.containsKey(id)){
            user = users.get(id);
        }
        return user;
    }
    public static User getUserByName(String name){
        User user = null;
        for (User tempUser: users.values()
             ) {
            if (tempUser.getName().equals(name)) {
                user = tempUser;
            }
        }
        return user;
    }
    public static void addUser(User user) {
        users.put(user.getId(),user);
    }
    public static boolean removeUser(String id) {
        boolean status = false;

        if (users.containsKey(id)) {
            users.remove(id);
        }
        return status;
    }
    public static void addProduct(Product product) {
        products.put(product.getId(), product);
    }
    public static boolean removeProduct(String id) {
        boolean status = false;
        if (products.containsKey(id)) {
            products.remove(id);
        }
        return status;
    }
    public static ArrayList<Product> getProductsByPriceRange(float a, float b) {
        ArrayList<Product> reArr = new ArrayList<>();
        for (Product tempProduct: products.values()
             ) {
            if (tempProduct.getPrice() >= a && tempProduct.getPrice() < b) {
                reArr.add(tempProduct);
            }
        }
        return reArr;
    }
    public static ArrayList<Product> getProducts(){
        ArrayList<Product> reArr = new ArrayList<>();
        for (Product tempProduct: products.values()
        ) {
            reArr.add(tempProduct);
        }
        return reArr;
    }
    public static Product getProductById(String id){
        Product reProduct = null;
        if (products.containsKey(id)) {
            reProduct = products.get(id);
        }
        return reProduct;
    }

    public static Product getProductByName(String name) {
        Product reProduct = null;
        for (Product tempProduct: products.values()
             ) {
            if (tempProduct.getName().equals(name)){
                reProduct = tempProduct;
                break;
            }
        }
        return reProduct;
    }
}
