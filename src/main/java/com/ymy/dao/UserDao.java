package com.ymy.dao;

import com.ymy.entity.User;

import java.util.List;

public interface UserDao {


    List<User> findAllUser();


    User findUserById(int id);


    int updateUserById(User user);

}
