package com.ymy.controller;

import com.google.gson.Gson;
import com.ymy.entity.Department;
import com.ymy.service.DepartmentService;
import com.ymy.service.Impl.DepartmentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DepartmentListServlet")
public class DepartmentListServlet extends HttpServlet {

    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {

        departmentService=new DepartmentServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Department> departmentList=departmentService.findAllDepartment();

        response.getWriter().print(new Gson().toJson(departmentList));

    }

}
