package day10.exercise;

import java.io.Serializable;

public class Order implements Serializable {
    private String orderId = null;
    private String pdtId = null;
    private int pdtNum = 0;

    public Order() {
    }

    public Order(final String orderId, final String pdtId, final int pdtNum) {
        this.orderId = orderId;
        this.pdtId = pdtId;
        this.pdtNum = pdtNum;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public String getPdtId() {
        return this.pdtId;
    }

    public void setPdtId(final String pdtId) {
        this.pdtId = pdtId;
    }

    public int getPdtNum() {
        return this.pdtNum;
    }

    public void setPdtNum(final int pdtNum) {
        this.pdtNum = pdtNum;
    }

    @Override
    public String toString() {
        return "Order: " + orderId + ", " + pdtId + ", " + pdtNum;
    }
}
