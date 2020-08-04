package com.ymy.dao.Impl;

import com.alibaba.druid.util.Base64;
import com.ymy.dao.BaseDao;
import com.ymy.dao.DepartmentDao;
import com.ymy.entity.Department;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {


    private BaseDao baseDao=BaseDao.getInstance();

    @Override
    public List<Department> findAllDepartment() {

        String sql="select * from department";

        return baseDao.executeQuery(sql,null,Department.class) ;

    }
}
