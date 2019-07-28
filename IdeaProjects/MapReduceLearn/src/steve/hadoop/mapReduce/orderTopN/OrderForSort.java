package steve.hadoop.mapReduce.orderTopN;

import org.apache.hadoop.io.Text;

public class OrderForSort {
    private OrderWritable orderWritable;
    private Text text;

    public OrderForSort(OrderWritable orderWritable, Text text) {
        this.orderWritable = orderWritable;
        this.text = text;
    }

    public OrderWritable getOrderWritable() {
        return orderWritable;
    }

    public Text getText() {
        return text;
    }
}
