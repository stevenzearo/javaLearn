package day10.exercise;

import java.io.Serializable;

public class Product implements Serializable {
    private String pId = null;
    private String pName = null;
    private float pPrice = 0f;

    public Product() {
    }

    public Product(String pId, String pName, float pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pPrice = pPrice;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getpPrice() {
        return pPrice;
    }

    public void setpPrice(float pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "Product: "+pId+", "+pName+", "+pPrice;
    }
}
