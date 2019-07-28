package day07.ProductManagementSystem.service;

import day07.ProductManagementSystem.User;

public interface Service {

    public boolean register(String id, String name, String password1);
    public boolean checkUserExistence(String id);
    public boolean login(String name, String password);
    public boolean amendUserInfo(String id, String name, String password);
    public boolean addProduct(String id, String name, float price, int amount);
    public void showAllProducts();
    public void showProductById(String id);
    public void showProductByName(String name);
    public void showProductByPriceRange(float a, float b);
    public boolean removeProductById(String id);
}
