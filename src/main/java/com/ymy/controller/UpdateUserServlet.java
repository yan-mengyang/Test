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

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {

        userService=new UserServiceImpl();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user=new User();

        String id = request.getParameter("id");
        if (id!=null && !id.equals(" ")){
            user.setId(Integer.valueOf(id));
        }
        String username=request.getParameter("username");
        user.setUsername(username);

        String age =request.getParameter("age");
        if (age!=null && !age.equals("")){
            user.setAge(Integer.valueOf(age));
        }
        String sexid=request.getParameter("sexid");
        user.setSexid(sexid);

        String department=request.getParameter("department");

        if (department!=null && !department.equals("")){
            user.setDepartment(Integer.valueOf(department));
        }

        String birthday =request.getParameter("birthday");
        user.setBirthday(birthday);


        System.out.println(user);

        int num=userService.updateUserById(user);
        System.out.println(num);
        if (num > 0) {
            request.setAttribute("msg", "修改成功");
            request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "修改失败");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }

    }
}
