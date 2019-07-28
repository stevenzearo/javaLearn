package day08.sortUtil;

import day08.User;

public class SortByAgeAndWage implements SortRule{

    @Override
    public boolean sort(User user1, User user2) {
        boolean status = false;
        if (user1.getAge() > user2.getAge()){
            status = true;
        } else if (user1.getAge() == user2.getAge()) {
            if (user1.getWage() > user1.getWage()){
                status = true;
            }
        }
        return status;
    }
}
