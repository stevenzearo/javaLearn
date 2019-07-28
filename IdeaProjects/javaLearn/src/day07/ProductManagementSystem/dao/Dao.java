package day07.ProductManagementSystem.dao;

import day07.ProductManagementSystem.Product;
import day07.ProductManagementSystem.User;

import java.util.ArrayList;

public interface Dao {
    public boolean addUser(User user);
    public User getUser(String id);
    public User getUserByName(String name);
    public boolean addProduct(Product product);
    public ArrayList<String> showProducts();
    public String showProductById(String id);
    public String showProductByName(String name);
    public ArrayList<String> showProductsByPriceRange(float a, float b);
    public boolean removeProduct(String id);

}
