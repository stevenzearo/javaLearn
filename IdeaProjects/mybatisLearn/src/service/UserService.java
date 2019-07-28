package service;

import model.User;

import java.util.List;

public interface UserService {
    public User findUserById(int id);
    public List<User> findUsersByName(String uname);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int id);

}
