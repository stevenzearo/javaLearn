package day09.wordCount;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    public static void main(String[] args){
        File myFile = new File("myFileTest.txt");
        Reader reader = new ReaderImpl();
        Count count = new CountImpl();
        Sort sort = new SortImpl();
        ArrayList<String> arrayList = reader.getWords(myFile);
        HashMap<String, Integer> map = count.countWords(arrayList);
        ArrayList<Map.Entry<String, Integer>> arrayList1 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()
             ) {
            arrayList1.add(entry);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("**************************");
        sort.sort(arrayList1);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i).getKey() + ": " + arrayList1.get(i).getValue());
        }
    }

}
