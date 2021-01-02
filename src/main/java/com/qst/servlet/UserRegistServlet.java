package com.qst.servlet;

import com.google.gson.Gson;
import com.qst.bean.User;
import com.qst.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(urlPatterns = "/UserRegistServlet")
public class UserRegistServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        if("register".equals(action)){
            register(request,response);
        }else if("ajaxExistsUsername".equals(action)){
            ajaxExistsUsername(request,response);
        }

    }

    protected void register(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        //获取前台注册所需要的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String repwd = request.getParameter("repwd");
        String jurisdiction = request.getParameter("jurisdiction");
        String code = request.getParameter("code");

        // 获取 Session 中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session 中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        User user = new User(null,username,password,email,Integer.valueOf(jurisdiction));
        UserDao userDao = new UserDao();

        Integer count = userDao.selectUsernameCount(username);



        if(token!=null && token.equalsIgnoreCase(code)){
            if(!repwd.equals(password) && repwd != null){
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('确认密码不同或密码为空！');");
                writer.write("window.location.href='/FlowerManageSystem/pages/user/regist.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                if(count>0){
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('用户名已存在！');");
                    writer.write("window.location.href='/FlowerManageSystem/pages/user/regist.jsp'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                }else {
                    boolean flag = userDao.saveUser(user);

                    if (flag){
                        request.getSession().setAttribute("user",user);
                        response.sendRedirect("/FlowerManageSystem/pages/user/regist_success.jsp");
                    }else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/FlowerManageSystem/pages/user/regist.jsp");
                        dispatcher.forward(request,response);
                    }
                }
            }
        }else{
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('验证码输入错误！');");
            writer.write("window.location.href='/FlowerManageSystem/pages/user/regist.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void ajaxExistsUsername(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");

        UserDao userDao = new UserDao();
        boolean existUsername = userDao.existUsername(username);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        response.getWriter().write(json);

    }
}
