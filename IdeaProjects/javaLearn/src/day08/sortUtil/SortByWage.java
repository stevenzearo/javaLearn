package day08.sortUtil;

import day08.User;

public class SortByWage implements SortRule {
    @Override
    public boolean sort(User user1, User user2) {
        boolean status = false;
        if (user1.getWage() > user2.getWage()){
            status = true;
        }
        return status;
    }
}
