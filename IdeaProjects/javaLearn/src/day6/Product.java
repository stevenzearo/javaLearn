package day6;

public class Product {
    private String pId;
    private String pName;
    private float price;
    private int num;
    public Product(){}
    public Product(String pId, String pName, float price, int num) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.num = num;
    }

    public String getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public float getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
