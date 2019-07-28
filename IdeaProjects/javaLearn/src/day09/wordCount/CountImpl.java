package day09.wordCount;

import java.util.ArrayList;
import java.util.HashMap;

public class CountImpl implements Count {

    @Override
    public HashMap<String, Integer> countWords(ArrayList<String> strings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            int count = 1;
            if (map.containsKey(string)){
                count = map.get(string) + 1;
                map.put(string, count);
            } else {
                map.put(string, count);
            }

        }
        return map;
    }
}
