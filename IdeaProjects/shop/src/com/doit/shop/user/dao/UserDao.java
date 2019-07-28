package com.doit.shop.user.dao;

import com.doit.shop.user.bin.User;

import java.util.List;

public interface UserDao {
    /*
    * 增加用户
    * */
    public boolean addUser(User user);

    /*
    * 移除用户
    * */
    public boolean removeUser(String account);

    /*
    * 修改用户信息
    * */
    public boolean updateUser(User user);

    /*
    * 查询用户信息
    * */
    public User getUserByAccount(String account);

    /*
    * 按照年龄范围查找多个用户
    * */
    public List<User> getUsersByAgeRange(int min, int max);

    /*
    * 按照vipLevel范围查找多个用户
    * */
    public List<User> getUsersByVipLevel(int minVipLevel, int maxVipLevel);

    /*
    * 根据姓名查找多个用户
    * */
    public List<User> getUsersByName(String name);
}
