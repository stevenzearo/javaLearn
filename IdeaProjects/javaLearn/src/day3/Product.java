package day3;

public class Product {
    public String pId;
    public String pName;
    public float price;
    public int number;
    public Product(String pId, String pName, float price, int number) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.number = number;
    }

    @Override
    public String toString() {
        String temp = this.pId + "," + this.pName + "," + this.price + "," + this.number;
        return temp;
    }
    public float getAmount() {
        float amount = this.price + (float)this.number;
        return amount;
    }
}
