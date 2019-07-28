package day07.service;

import day07.bin.User;
import day07.dao.UserDao;
import day07.dao.UserDaoImpl;


public class UserServiceImpl implements UserService{

    UserDao userDao= new UserDaoImpl();
    @Override
    public boolean login(String name, String password) {
        boolean status = false;
//        调DAO层功能查询用户是否存在（传入用户名返回user对象）
        User user = userDao.findUserByName(name);
        if (user == null) {
            status = false;
            }else if (user.getPassword().equals(password)){
            status = true;
        }
        return status;
    }

    @Override
    public int register(String name, String password, String password2) {
        int status = 0;
//        调用DAO层接口判断用户名是否存在
        boolean userStatus = userDao.checkUserExistence(name);

//        用户已存在则status=2,否则进入用户创建步骤
        if (userStatus) {
            status = 2;
        } else {
//            前后密码一致则创建用户且status=1,不一致,status为3
            if (password2.equals(password)) {
                User user1 = new User(name, password);
                userDao.addUser(user1);
                status = 1;
            } else {
                status = 3;
            }
        }
        return status;
    }
}
