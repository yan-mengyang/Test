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

@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
       userService=new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user =userService.findUserById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/jsp/updateUser.jsp").forward(request,response);

    }
}
