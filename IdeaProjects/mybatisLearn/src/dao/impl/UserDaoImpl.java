package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User findUserById(int id){
        SqlSession session = MybatisUtil.getFactory().openSession();
//        User user = session.selectOne("dao.UserDao.findUserById", id);
        /*
        * mybatis通过动态代理(cglib.jar)加载mapper.xml中的statement，将底层的数据关系一一映射
        * */
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.findUserById(id);
        session.close();
        return user;
    }

    @Override
    public List<User> findUsersByName(String uname) {
        SqlSession session = MybatisUtil.getFactory().openSession();
        List<User> users = session.selectList("dao.UserDao.findUsersByName", uname);
        session.close();
        return users;
    }

    @Override
    public boolean addUser(User user){
        try {
            SqlSession session = MybatisUtil.getFactory().openSession();
            session.insert("dao.UserDao.addUser", user);
            session.commit();
            session.close();

        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user){
        try {
            SqlSession session = MybatisUtil.getFactory().openSession();
            session.update("dao.UserDao.updateUser", user);
//            session.getMapper(UserDao.class);
            session.commit();
            session.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(int id){
        try {
            SqlSession session = MybatisUtil.getFactory().openSession();
            session.delete("dao.UserDao.deleteUser", id);
            session.commit();
            session.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
