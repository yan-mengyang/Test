package com.ymy.controller;


import com.ymy.entity.User;
import com.ymy.service.Impl.UserServiceImpl;
import com.ymy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {

        userService=new UserServiceImpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> userList=userService.findAllUser();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/jsp/userList.jsp").forward(request,response);

    }
}
