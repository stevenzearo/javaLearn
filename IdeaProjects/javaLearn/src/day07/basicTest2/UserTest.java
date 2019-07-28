package day07.basicTest2;

import java.util.ArrayList;
import java.util.HashMap;

public class UserTest {
    public static void main(String[] args){
        User user1 = new User("1", "张三", 18, 2000f);
        User user2 = new User("2", "李四", 20, 3000f);
        User user3 = new User("3", "王五", 19, 2500f);
        User user4 = new User("4", "赵六", 19, 2600f);
        User user5 = new User("5", "铁蛋", 20, 2800f);

        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.add(user4);
        arrayList.add(user5);

        //        对arrayList按age降序排序
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = 0; j < arrayList.size()-i-1; j++) {
                User tempUser = arrayList.get(j+1);
                if (arrayList.get(j).getAge() < arrayList.get(j+1).getAge()){
                    arrayList.set(j+1, arrayList.get(j));
                    arrayList.set(j, tempUser);
                }
            }
        }
        System.out.println(arrayList);

        //        对arrayList按salary升序排序
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = 0; j < arrayList.size()-i-1; j++) {
                User tempUser2 = arrayList.get(j+1);
                if (arrayList.get(j).getSalary() > arrayList.get(j+1).getSalary()){
                    arrayList.set(j+1, arrayList.get(j));
                    arrayList.set(j, tempUser2);
                }
            }
        }
        System.out.println(arrayList);
        //        对arrayList按age和salary升序排序
        for (int i = 0; i < arrayList.size()-1; i++) {
            for (int j = 0; j < arrayList.size()-i-1; j++) {
                User tempUser2 = arrayList.get(j+1);
                if (arrayList.get(j).getAge() > arrayList.get(j+1).getAge()){
                    arrayList.set(j+1, arrayList.get(j));
                    arrayList.set(j, tempUser2);
                } else if (arrayList.get(j).getAge() == arrayList.get(j+1).getAge()){}
                if (arrayList.get(j).getSalary() > arrayList.get(j+1).getSalary()){
                    arrayList.set(j+1, arrayList.get(j));
                    arrayList.set(j, tempUser2);
                }
            }
        }
        System.out.println(arrayList);
        HashMap<String, User> hashMap = new HashMap<>();
        ArrayList<User> arrayList1 = new ArrayList<>();
        hashMap.put(user1.getId(), user1);
        hashMap.put(user2.getId(), user2);
        hashMap.put(user3.getId(), user3);
        hashMap.put(user4.getId(), user4);
        hashMap.put(user5.getId(), user5);
        System.out.println("hashMap: "+hashMap);
        for (User tempUser: hashMap.values()
        ) {
            if (tempUser.getSalary() >= 2500) {
                arrayList1.add(tempUser);

            }
        }
        for (int i=0; i < arrayList1.size(); i++) {
            User tempUser = arrayList1.get(i);
            if (tempUser.getSalary() >= 2500) {
                hashMap.remove(tempUser.getId(), tempUser);
            }
        }
        System.out.println("hashMap: "+hashMap);
        System.out.println("arrayList1: "+arrayList1);
    }
}
