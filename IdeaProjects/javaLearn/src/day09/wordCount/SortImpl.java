package day09.wordCount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class SortImpl implements Sort {

    @Override
    public void sort(ArrayList<Map.Entry<String, Integer>> arrayList) {
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                int status = 0;
                if (entry1.getValue() > entry2.getValue()) {
                    status = -1;
                } else if(entry1.getValue() == entry2.getValue()){
                    if (entry1.getKey().length() > entry2.getKey().length()){
                        status = 1;
                    } else {
                        status = -1;
                    }
                } else {
                    status = 1;
                }
                return status;
            }
        };
        arrayList.sort(comparator);
    }
}
