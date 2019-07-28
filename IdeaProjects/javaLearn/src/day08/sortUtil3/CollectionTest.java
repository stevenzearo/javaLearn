package day08.sortUtil3;

import day08.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionTest {
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
//        collections工具排序方法1，创建比较器
        Collections.sort(userArrayList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getAge()-o2.getAge();
                int status = 0;
                if (result >0 ) {
                    status = 1;
                } else {
                    status = -1;
                }
                return status;
            }
        });
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }
        System.out.println("***********");
//        collections工具排序方法2，要比较的类继承comparable接口,再调用collections的sort方法
        Collections.sort(userArrayList);
        for (int i = 0; i < userArrayList.size(); i++) {
            System.out.println(userArrayList.get(i));

        }
    }
}
