package day07.ProductManagementSystem;

public class Product {
    private String id;
    private String name;
    private float price;
    private int amount;

    public Product() {
    }

    public Product(String id, String name, float price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.amount;
    }

    public void setQuantity(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+amount;
    }
}
