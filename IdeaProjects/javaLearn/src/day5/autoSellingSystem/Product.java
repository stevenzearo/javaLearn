package day5.autoSellingSystem;


public class Product {

    private String id;
    private String name;
    private String category;
    private float price;
    private int number;

    public Product(){}
    public Product(String id, String name, String category, float price, int number){
        this.id = id;
        this.name = name;
        this.category =category;
        this.price = price;
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return id + " | " + name +  " | " + category + " | " + price + " | " + number;
    }
}
