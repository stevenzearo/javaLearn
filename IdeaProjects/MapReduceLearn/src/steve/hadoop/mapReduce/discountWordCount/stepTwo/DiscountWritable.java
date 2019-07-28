package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DiscountWritable implements WritableComparable<DiscountWritable> {
    private String discount;
    private long num;

    public DiscountWritable() {
    }

    public DiscountWritable(String discount, long num) {
        this.discount = discount;
        this.num = num;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DiscountWritable: " + discount + " " + num;
    }

//    设置降序排序
    @Override
    public int compareTo(DiscountWritable discountWritable) {

        return (int)(discountWritable.getNum()-this.getNum());
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.discount);
        dataOutput.writeLong(this.num);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

        this.discount = dataInput.readUTF();
        this.num = dataInput.readLong();
    }
}
