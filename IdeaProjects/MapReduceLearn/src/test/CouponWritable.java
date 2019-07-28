package test;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//, WritableComparable
public class CouponWritable implements Writable, WritableComparable{

    private String user;
    private String id;
    private String discount;

    public CouponWritable(){}
    public CouponWritable(String user, String id, String discount) {
        this.user = user;
        this.id = id;
        this.discount = discount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    @Override
    public String toString() {
        return "CouponWritable: [" + "id: " +id + ", " + "user:" + user + ", " + "discount: " + discount + "]";
    }

    /*
    * 定义对象的序列化方式
    *
    * */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(user);
        dataOutput.writeUTF(id);
        dataOutput.writeUTF(discount);
    }

    /*
    * 定义对象的反序列化方式
    *
    * */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        user = dataInput.readUTF();
        id = dataInput.readUTF();
        discount = dataInput.readUTF();
    }

    @Override
    public int compareTo(Object o) {
        CouponWritable couponWritable1 = (CouponWritable) o;
        if (this.getId().compareTo(couponWritable1.getId()) == 0) {
            return this.getUser().compareTo(couponWritable1.getUser());
        }
        return this.getId().compareTo(couponWritable1.getId());
    }
}
