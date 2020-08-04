package com.ymy.dao.Impl;

import com.ymy.dao.BaseDao;
import com.ymy.dao.UserDao;
import com.ymy.entity.User;

import java.util.List;

public class UserDaoImpl  implements UserDao {

    private BaseDao baseDao=BaseDao.getInstance();

    @Override
    public List<User> findAllUser() {
        String sql="select b.*,c.departmentname  from user b left join department c on b.department=c.id";

        return baseDao.executeQuery(sql,null,User.class);
    }

    @Override
    public User findUserById(int id) {

        String sql ="select b.*,c.departmentname from user b left join department c on b.department=c.id where b.id=?";
        Object[] params={id};
     List<User> userList=baseDao.executeQuery(sql,params,User.class);
        return userList.get(0);
    }

    @Override
    public int updateUserById(User user) {

        String sql="update user set username=?,age=?,sexid=?,department=?,birthday=? where id=?";
        Object[] params={user.getUsername(),user.getAge(),user.getSexid(),user.getDepartment(),user.getBirthday(),user.getId()};
        return baseDao.executeUpdate(sql,params);
    }
}
