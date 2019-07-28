package day08.sortUtil;

import day08.User;

public class SortByAge implements SortRule {

    @Override
    public boolean sort(User user1, User user2) {
        boolean status = false;
        if (user1.getAge() > user2.getAge()){
            status = true;
        }
        return status;
    }
}
