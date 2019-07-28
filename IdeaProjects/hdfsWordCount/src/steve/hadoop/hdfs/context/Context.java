package steve.hadoop.hdfs.context;

import java.util.HashMap;

public class Context {
    private HashMap<Object, Object> contextMap = new HashMap<>();

    public HashMap<Object, Object> getContextMap() {
        return contextMap;
    }

    public void set(Object key, Object value) {
        contextMap.put(key, value);
    }
    public void setContextMap(HashMap<Object, Object> contextMap) {
        this.contextMap = contextMap;
    }

    public Object getValue(Object key){
        return contextMap.get(key);
    }

    public boolean containsKey(Object key) {
        return contextMap.containsKey(key);
    }
}
