package day08.sortUtil2;

import day08.User;

import java.util.ArrayList;

public class SortTest2 {
    public static void main(String[] args){
        User user1 = new User("0001", "adam", 23, 2356.7f);
        User user2 = new User("0002", "tom", 21, 2100f);
        User user3 = new User("0003", "alis", 24, 2256.8f);
        User user4 = new User("0004", "john", 22, 2431.3f);
        User user5 = new User("0005", "steve", 23, 2212.9f);

        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);
        userArrayList.add(user4);
        userArrayList.add(user5);

        SortByAge2 sortByAge2 = new SortByAge2();
        SortUtil2<User> sortUtil2 = new SortUtil2<>();
        sortUtil2.sort(userArrayList, sortByAge2);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }

    }
}
