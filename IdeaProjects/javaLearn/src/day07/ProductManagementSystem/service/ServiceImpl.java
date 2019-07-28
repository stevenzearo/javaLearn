package day07.ProductManagementSystem.service;

import day07.ProductManagementSystem.DataBase;
import day07.ProductManagementSystem.Product;
import day07.ProductManagementSystem.User;
import day07.ProductManagementSystem.dao.Dao;
import day07.ProductManagementSystem.dao.DaoImpl;

import java.util.ArrayList;

public class ServiceImpl implements Service {
    Dao dao = new DaoImpl();
    @Override
    public boolean register(String id, String name, String password1) {
        User user = new User(id, name, password1);
        boolean status = dao.addUser(user);
        return status;
    }

    @Override
    public boolean checkUserExistence(String id) {
        boolean status = false;
        User user = dao.getUser(id);
        if (user != null) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean login(String name, String password) {
        boolean status = false;
        User user = dao.getUserByName(name);
        if (user.getPassword().equals(password)) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean amendUserInfo(String id, String name, String password) {
        return false;
    }

    @Override
    public boolean addProduct(String id, String name, float price, int amount) {
        Product product = new Product(id, name, price, amount);

        boolean status = dao.addProduct(product);
        return status;
    }

    @Override
    public void showAllProducts() {
        ArrayList<String> strings = dao.showProducts();
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));

        }
    }

    @Override
    public void showProductById(String id){
        String string = dao.showProductById(id);
        System.out.println(string);
    }

    @Override
    public void showProductByName(String name){
        String string = dao.showProductByName(name);
        System.out.println(string);
    }
    @Override
    public void showProductByPriceRange(float a, float b) {
        ArrayList<String> strings = dao.showProductsByPriceRange(a, b);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));

        }
    }

    @Override
    public boolean removeProductById(String id) {
        boolean status = dao.removeProduct(id);

        return status;
    }
}
