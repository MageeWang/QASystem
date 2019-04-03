package com.ex;

import com.sun.istack.internal.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginConfirm")
public class LoginConfirm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if(request.getAttribute("username")!=null&&request.getAttribute("password").equals("admin")){
            request.getSession().setAttribute("username",request.getAttribute("username"));
            System.out.println(request.getSession().getAttribute("username"));
            //response.sendRedirect("http://localhost:8080/index.jsp");
        }else {
            response.sendRedirect("/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
