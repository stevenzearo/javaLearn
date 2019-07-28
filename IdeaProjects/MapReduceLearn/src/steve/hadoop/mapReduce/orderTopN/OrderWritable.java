package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderWritable implements WritableComparable<OrderWritable> {
    private String orderId;
    private String userId;
    private String productName;
    private float price;
    private int num;
    private float amount;

    public OrderWritable() {
    }

    public OrderWritable(String orderId, String userId, String productName, float price, int num) {
        this.orderId = orderId;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.num = num;
        this.amount = price * num;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "OrderWritable: {orderId: " + orderId + ", userId: " + userId + ", productName: " + productName + ", price: "
                + price + ", num: " + num + ", amount: " + amount + "}";
    }

    @Override
    public int compareTo(OrderWritable orderWritable) {
        if (orderWritable.getOrderId().compareTo(this.getOrderId()) == 0) {

            return (int)((orderWritable.getAmount() - this.getAmount()) * 10);
        }

        return orderWritable.getOrderId().compareTo(this.getOrderId());
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {

        dataOutput.writeUTF(orderId);
        dataOutput.writeUTF(userId);
        dataOutput.writeUTF(productName);
        dataOutput.writeFloat(price);
        dataOutput.writeInt(num);
        dataOutput.writeFloat(amount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

        this.orderId = dataInput.readUTF();
        this.userId = dataInput.readUTF();
        this.productName = dataInput.readUTF();
        this.price = dataInput.readFloat();
        this.num = dataInput.readInt();
        this.amount = dataInput.readFloat();
    }
}
