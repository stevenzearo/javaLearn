package dao;

import model.User;

import java.util.List;

public interface UserDao {

//    findUserById
    public User findUserById(int id);

//    findUsersByName
    public List<User> findUsersByName(String uname);

//    addUser
    public boolean addUser(User user);

//    updateUser
    public boolean updateUser(User user);

//    deleteUser
    public boolean deleteUser(int id);
}
