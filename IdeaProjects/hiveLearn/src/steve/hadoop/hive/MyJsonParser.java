package steve.hadoop.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyJsonParser extends UDF {
    public String evaluate(String json, int index){
//        index从1开始计数

//        {"movie":"1193","rate":"5"}
        String[] words = json.split("\"");

        return words[2*index + 1];
    }

}
