package steve.hadoop.hdfs.Mapper;

import steve.hadoop.hdfs.context.Context;

public class WordCountMapper implements Mapper {

    @Override
    public void map(Object key, Context context) {
        if (context.containsKey(key)) {
            int conVal = (int) context.getValue(key);
            context.set(key, conVal+1);
        } else {
            context.set(key, 1);
        }
    }
}
