package com.ymy.service.Impl;

import com.ymy.dao.DepartmentDao;
import com.ymy.dao.Impl.DepartmentDaoImpl;
import com.ymy.entity.Department;
import com.ymy.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao=new DepartmentDaoImpl();

    @Override
    public List<Department> findAllDepartment() {


        return departmentDao.findAllDepartment();
    }
}
