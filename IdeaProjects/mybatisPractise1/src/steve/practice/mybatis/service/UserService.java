package steve.practice.mybatis.service;

import steve.practice.mybatis.model.User;
import steve.practice.mybatis.viewObject.ProductVo;

import java.util.List;

public interface UserService {
    public User findUserByUserNameAndPassword(User user);
    public List<User> findUsersAndOrders();
}
