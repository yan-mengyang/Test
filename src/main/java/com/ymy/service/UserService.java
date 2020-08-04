package com.ymy.service;

import com.ymy.entity.User;

import java.util.List;

public interface UserService {


    List<User> findAllUser();


    User findUserById(int id);



    int updateUserById(User user);

}
