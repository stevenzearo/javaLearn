package steve.hadoop.hdfs.Mapper;

import steve.hadoop.hdfs.context.Context;

import java.util.HashMap;

public interface Mapper {
    public void map(Object key, Context context);
}
