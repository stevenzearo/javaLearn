package day08.mySortUtil;

import java.util.ArrayList;

public class MySort<T> {
    public void sort(ArrayList<T> arrayList, MyCompare<T> compare) {
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = 0; j < arrayList.size()-1-i; j++) {
                if (compare.compare(arrayList.get(j), arrayList.get(j+1))){
                    T tempO = arrayList.get(j + 1);
                    arrayList.set(j+i, arrayList.get(j));
                    arrayList.set(j, tempO);
                }
            }
        }
    }
}
