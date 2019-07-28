package day08.sortUtil2;

import day08.User;

public class SortByAge2 implements SortRule2<User> {

    @Override
    public boolean sort(User user1, User user2) {
        boolean status = false;
        if (user1.getAge() > user2.getAge()){
            status = true;
        }
        return status;
    }
}
