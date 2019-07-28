package day07.dao;

import day07.bin.User;

public interface UserDao {

    public User findUserByName(String name);
    public boolean checkUserExistence(String name);
    public void addUser(User user);

}
