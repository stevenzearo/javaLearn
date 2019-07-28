package service.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import service.UserService;
import util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSession session = null;


    @Override
    public User findUserById(int id) {
        session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUsersByName(String uname) {
        session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.findUsersByName(uname);
    }

    @Override
    public boolean addUser(User user) {
        session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        session = MybatisUtil.getFactory().openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        return userDao.deleteUser(id);
    }
}
