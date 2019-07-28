package day08.sortUtil;

import day08.User;

import java.util.ArrayList;

public class SortTest {
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

        SortByAge sortByAge = new SortByAge();
        SortByWage sortByWage = new SortByWage();
        SortByAgeAndWage sortByAgeAndWage = new SortByAgeAndWage();
        SortUtil.sort(userArrayList, sortByAge);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }

        System.out.println("**********************");
        SortUtil.sort(userArrayList, sortByWage);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }
        System.out.println("**********************");
        SortUtil.sort(userArrayList, sortByAgeAndWage);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }
    }
}
