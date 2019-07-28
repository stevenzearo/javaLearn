package tianchi;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper;


public class OrderCount extends Mapper<Writable,Writable,Writable,Writable> {
    private Writable userId;
    private Writable count;
    public void map(Writable key, Writable value,Context context){
        String line = value.toString();
        String[] ls = line.split(",");
        System.out.println(ls);


    }

    public static void main(String args[]) {
    }
}
