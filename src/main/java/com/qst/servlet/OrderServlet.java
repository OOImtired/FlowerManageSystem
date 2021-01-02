package com.qst.servlet;

import com.qst.bean.Cart;
import com.qst.bean.Order;
import com.qst.bean.OrderItem;
import com.qst.bean.User;
import com.qst.dao.OrderDao;
import com.qst.dao.OrderItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    OrderDao orderDao = new OrderDao();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        if(loginUser == null){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('还未登录账号，请登录后购买！');");
            writer.write("window.location.href='/FlowerManageSystem/pages/user/login.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderDao.createOrder(cart, userId);
        request.getSession().setAttribute("orderId",orderId);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }

    protected void queryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        User loginUser = (User) request.getSession().getAttribute("user");
        Integer userId = loginUser.getId();
        List<Order> orderList = orderDao.queryOrder(userId);
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }

    protected void queryOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderItemDao orderItemDao = new OrderItemDao();
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItemList = orderItemDao.queryOrderDetails(orderId);
        request.setAttribute("orderItemList",orderItemList);
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if("createOrder".equals(action)){
            createOrder(request,response);
        } else if ("queryOrder".equals(action)) {
            queryOrder(request,response);
        } else if("queryOrderDetails".equals(action)){
            queryOrderDetails(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
