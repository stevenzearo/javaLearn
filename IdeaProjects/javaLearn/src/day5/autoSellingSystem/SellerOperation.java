package day5.autoSellingSystem;

public abstract class SellerOperation {
    public static void addProducts() {
        Product p1 = new Product();
        p1.setId("pdt-0001");
        p1.setName("面包");
        p1.setCategory("食物");
        p1.setPrice(6.9f);
        p1.setNumber(100);

        Product p2 = new Product();
        p2.setId("pdt-0002");
        p2.setName("巧克力");
        p2.setCategory("食物");
        p2.setPrice(12.98f);
        p2.setNumber(100);

        Product p3 = new Product("pdt-0003", "沐浴露", "日化用品", 49.98f, 100);

        ProductManagement.addProduct(p1);
        ProductManagement.addProduct(p2);
        ProductManagement.addProduct(p3);
    }

}
