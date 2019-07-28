package steve.hadoop.hdfs.Reducer;

import steve.hadoop.hdfs.context.Context;

import java.util.ArrayList;
import java.util.Map;

public interface Reducer {
    public Context combineContext(Context context1, Context context2);

//    reverse为true时,列表降序
    public ArrayList<Map.Entry<Object, Object>> reduce(Context context, boolean reverse);
}
