package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderIdGroupingComparator extends WritableComparator {
//    重写父类中反序列化时实例构造方式
    public OrderIdGroupingComparator(){
        super(OrderWritable.class, true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderWritable o1 = (OrderWritable) a;
        OrderWritable o2 = (OrderWritable) b;
       return o1.getOrderId().compareTo(o2.getOrderId());
    }

}
