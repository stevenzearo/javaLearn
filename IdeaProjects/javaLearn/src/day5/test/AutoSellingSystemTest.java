package day5.test;

import day5.autoSellingSystem.Product;
import day5.autoSellingSystem.ProductManagement;

public class AutoSellingSystemTest {
    public static void main(String args[]) {
        Product p = new Product();
        p.setId("pdt-0001");
        p.setName("bread");
        p.setCategory("food");
        p.setPrice(6.9f);
        Product p2 = new Product();
        p2.setId("pdt-0002");
        p2.setName("chocolate");
        p2.setCategory("food");
        p2.setPrice(12.98f);
        ProductManagement.addProduct(p);
        ProductManagement.addProduct(p2);
        ProductManagement.showProducts();
    }
}
