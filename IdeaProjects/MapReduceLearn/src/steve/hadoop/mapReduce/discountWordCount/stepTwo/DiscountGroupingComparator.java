package steve.hadoop.mapReduce.discountWordCount.stepTwo;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DiscountGroupingComparator extends WritableComparator {

    public DiscountGroupingComparator(){
        super(DiscountWritable.class, true);
    }

/*
* 重写key的分组方式
*
*
* */
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        DiscountWritable d1 = (DiscountWritable) a;
        DiscountWritable d2 = (DiscountWritable) b;

        return d1.getDiscount().compareTo(d2.getDiscount());
    }
}
