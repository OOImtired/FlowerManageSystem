package com.qst.servlet;

import com.qst.bean.User;
import com.qst.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取前台所需信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        User user = userDao.getUserByUsernameAndPassword(username,password);

        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/FlowerManageSystem/pages/user/login_success.jsp");
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或密码错误！');");
            writer.write("window.location.href='/FlowerManageSystem/pages/user/login.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

        String method = request.getParameter("method");
        if("logout".equals(method)){
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath());
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
