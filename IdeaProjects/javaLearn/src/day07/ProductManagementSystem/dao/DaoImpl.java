package day07.ProductManagementSystem.dao;

import day07.ProductManagementSystem.DataBase;
import day07.ProductManagementSystem.Product;
import day07.ProductManagementSystem.User;

import java.util.ArrayList;

public class DaoImpl implements Dao {
    @Override
    public boolean addUser(User user) {
        boolean status = false;
        if (!DataBase.getUsers().containsValue(user)) {
            DataBase.addUser(user);
            status = true;
        }
        return status;
    }

    @Override
    public User getUser(String id) {
        return DataBase.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        User user = DataBase.getUserByName(name);
        return user;
    }

    @Override
    public boolean addProduct(Product product) {
        boolean status = false;
        if (!DataBase.getProducts().contains(product)){
            DataBase.addProduct(product);
            status = true;
        }
        return status;
    }

    @Override
    public ArrayList<String> showProducts() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Product> products = DataBase.getProducts();

        for (int i = 0; i < products.size(); i++) {
            strings.add(products.get(i).toString());
        }

        return strings;
    }

    @Override
    public String showProductById(String id) {
        Product product = DataBase.getProductById(id);
        String string = product.toString();
        return string;
    }

    @Override
    public String showProductByName(String name) {
        Product product = DataBase.getProductByName(name);
        String string = product.toString();
        return string;
    }

    @Override
    public ArrayList<String> showProductsByPriceRange(float a, float b) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Product> products = DataBase.getProductsByPriceRange(a,b);
        for (int i = 0; i < products.size(); i++) {
            strings.add(products.get(i).toString());

        }
        return strings;
    }

    @Override
    public boolean removeProduct(String id) {
        boolean status = false;
        if (DataBase.getProductById(id)!= null){
            DataBase.removeProduct(id);
            status = true;

        }
        return status;
    }
}
