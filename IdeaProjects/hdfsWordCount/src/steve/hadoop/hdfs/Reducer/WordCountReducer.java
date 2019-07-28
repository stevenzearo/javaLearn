package steve.hadoop.hdfs.Reducer;

import steve.hadoop.hdfs.context.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCountReducer implements Reducer {


    @Override
    public Context combineContext(Context context1, Context context2) {
        HashMap<Object, Object> contextMap1 = context1.getContextMap();
        HashMap<Object, Object> contextMap2 = context2.getContextMap();
        for (Map.Entry<Object, Object> entry: contextMap1.entrySet()
             ) {
            if (contextMap2.containsKey(entry.getKey())){
                int val1 = (int) entry.getValue();
                int val2 = (int) contextMap2.get(entry.getKey());
                context2.set(entry.getKey(), val1+val2);
            } else {
                context2.set(entry.getKey(), entry.getValue());
            }
        }
        return context2;
    }

    @Override
    public ArrayList<Map.Entry<Object, Object>> reduce(Context context, boolean reverse) {
        ArrayList<Map.Entry<Object, Object>> result = new ArrayList<>();
        HashMap<Object, Object> contextMap = context.getContextMap();
        for (Map.Entry<Object, Object> entry: contextMap.entrySet()
             ) {
            result.add(entry);
        }
        for (int i = 0; i < result.size()-1; i++) {
            for (int j = 0; j < result.size()-1-i; j++) {
                Map.Entry<Object, Object> ent1 = result.get(j);
                Map.Entry<Object, Object> ent2 = result.get(j+1);
                Map.Entry<Object, Object> entTmp = result.get(j+1);

                int val1 = (int) ent1.getValue();
                int val2 = (int) ent2.getValue();
                boolean command = val1 > val2;
                if (reverse) {
                    command = !command;
                }
                if (command){
                    result.set(j+1, ent1);
                    result.set(j, entTmp);
                }
            }
        }
        return result;
    }

}
