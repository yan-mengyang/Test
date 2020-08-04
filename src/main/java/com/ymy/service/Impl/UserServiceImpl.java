package com.ymy.service.Impl;

import com.ymy.dao.Impl.UserDaoImpl;
import com.ymy.dao.UserDao;
import com.ymy.entity.User;
import com.ymy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public List<User> findAllUser() {

        return userDao.findAllUser() ;
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public int updateUserById(User user) {

        return userDao.updateUserById(user);
    }
}
