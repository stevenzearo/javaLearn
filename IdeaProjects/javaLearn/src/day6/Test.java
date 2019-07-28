package day6;

import java.util.*;

public class Test {

    public static ArrayList<Product> userCartInfo(String name, HashMap<String, ArrayList<Product> >cart){
        return cart.get(name);
    }

    public static void main(String args[]) {
        User user1 = new User("0001", "tom", "1234", "123123123", 3000, 23);
        User user2 = new User("0002", "john", "1231", "212123213", 3500, 22);
        User user3 = new User("0003", "adam", "2134", "321213123", 2800, 24);
        User user4 = new User("0004", "george", "2213", "221332112", 3100, 22);

        User[] users = new User[4];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;
        users[3] = user4;

        ArrayList<User> ls1 = new ArrayList<>();
        ls1.add(user1);
        ls1.add(user2);
        ls1.add(user3);
        ls1.add(user4);
//        找出ls1中age最大的user
        User lsUser = ls1.get(0);
        for (int i = 0; i < ls1.size(); i++) {
            if (lsUser.getAge() < ls1.get(i).getAge()) {
                lsUser = ls1.get(i);
            }
        }
        System.out.println("lsUser: "+lsUser);

        HashSet<User> set1 = new HashSet<>();
        set1.add(user1);
        set1.add(user2);
        set1.add(user3);
        set1.add(user4);
//        找出set1中wage最大的user
        User setUser = new User();
        for (User tempUser: set1) {
            if (tempUser.getWage() > setUser.getWage()){
                setUser = tempUser;
            }
        }
        System.out.println("setUser: "+setUser);

        HashMap<String, User> map1 = new HashMap<>();
        map1.put(user1.getId(), user1);
        map1.put(user2.getId(), user2);
        map1.put(user3.getId(), user3);
        map1.put(user4.getId(), user4);
        int minAge = user1.getAge();
        Iterator<String> iterator = map1.keySet().iterator();
        User mapUser = map1.get(iterator.next());

        for (User tempUser: map1.values()) {
            if (tempUser.getAge() < minAge) {
                mapUser = tempUser;
            }

        }
        System.out.println("mapUser: "+mapUser);
//        找出map1中age最小的user
//        wordCount
        System.out.println("************************");
        Set<Map.Entry<String, User>> entrySet = map1.entrySet();
        for (Map.Entry ent: entrySet
        ) {
            System.out.println(ent.getKey()+" | "+ent.getValue());
        }
        Product p1 = new Product("1", "香蕉", 2.5f, 3);
        Product p2 = new Product("2", "橘子", 3.4f, 6);
        Product p3 = new Product("3", "苹果", 5.2f, 5);
        Product p4 = new Product("4", "哈密瓜", 9.8f, 4);
        Product p5 = new Product("5", "橙子", 12.3f, 2);

        User wr = new User("0005", "王二");
        User zs = new User("0006", "张三");
        User ls = new User("0007", "李四");
        HashMap<String, ArrayList<Product>> cartZs = new HashMap<>();
        ArrayList<Product> zsPdts = new ArrayList<>();
        p1.setNum(2);
        zsPdts.add(p1);
        p3.setNum(4);
        zsPdts.add(p3);
        p5.setNum(1);
        zsPdts.add(p5);
        cartZs.put(zs.getName(),zsPdts);

        HashMap<String, ArrayList<Product>> cartLs = new HashMap<>();
        ArrayList<Product> lsPdts = new ArrayList<>();
        p2.setNum(3);
        zsPdts.add(p2);
        p4.setNum(1);
        zsPdts.add(p4);
        p3.setNum(1);
        zsPdts.add(p3);
        cartLs.put(ls.getName(), lsPdts);

        System.out.println(Test.userCartInfo("张三", cartZs));
    }
}
