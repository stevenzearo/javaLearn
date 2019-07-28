package day08.sortUtil2;

import java.util.ArrayList;

public class SortUtil2<Object> {
    public void sort(ArrayList<Object> userArrayList, SortRule2<Object> sortRule){
        for (int i = 0; i < userArrayList.size()-1; i++) {
            for (int j = 0; j < userArrayList.size()-1-i; j++) {
                if (sortRule.sort(userArrayList.get(j), userArrayList.get(j+1))){
                    Object tempUser = userArrayList.get(j+1);
                    userArrayList.set(j+1, userArrayList.get(j));
                    userArrayList.set(j, tempUser);
                }
            }
        }
    }
}
