package steve.practice.mybatis.serviceImpl;

import org.apache.ibatis.session.SqlSession;
import steve.practice.mybatis.dao.UserDao;
import steve.practice.mybatis.model.User;
import steve.practice.mybatis.service.UserService;
import steve.practice.mybatis.util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User findUserByUserNameAndPassword(User user) {
        SqlSession session = MybatisUtil.getFactory().openSession();
//        利用动态代理获取User对象
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.findUserByNameAndPassword(user);
    }

    @Override
    public List<User> findUsersAndOrders() {
        SqlSession session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.findUsersAndOrders();
    }
}
