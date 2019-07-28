package steve.practice.mybatis.dao;

import steve.practice.mybatis.model.User;

import java.util.List;

public interface UserDao {
    public User findUserByNameAndPassword(User user);
    public List<User> findUsersAndOrders();

}
