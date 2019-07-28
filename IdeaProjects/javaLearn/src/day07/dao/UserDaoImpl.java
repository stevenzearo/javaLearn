package day07.dao;

import day07.UserDatabase;
import day07.bin.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByName(String name) {
        return UserDatabase.userInfo.get(name);
    }

    @Override
    public boolean checkUserExistence(String name) {
        return UserDatabase.userInfo.containsKey(name);
    }

    @Override
    public void addUser(User user) {
        UserDatabase.userInfo.put(user.getName(), user);
    }
}
