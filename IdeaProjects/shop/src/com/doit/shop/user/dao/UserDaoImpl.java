package com.doit.shop.user.dao;

import com.doit.shop.user.bin.User;

import java.util.List;

public class UserDaoImpl implements UserDao{


    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean removeUser(String account) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUserByAccount(String account) {
        return null;
    }

    @Override
    public List<User> getUsersByAgeRange(int min, int max) {
        return null;
    }

    @Override
    public List<User> getUsersByVipLevel(int minVipLevel, int maxVipLevel) {
        return null;
    }

    @Override
    public List<User> getUsersByName(String name) {
        return null;
    }
}
