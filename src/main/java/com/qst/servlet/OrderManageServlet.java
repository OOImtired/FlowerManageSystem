package com.qst.servlet;

import com.qst.bean.*;
import com.qst.dao.OrderDao;
import com.qst.dao.OrderItemDao;
import com.qst.dao.PageDao;
import com.qst.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/OrderManageServlet")
public class OrderManageServlet extends HttpServlet {

    protected void queryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        List<Order> orderList = orderDao.queryOrder();
        request.setAttribute("orderList",orderList);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    protected void queryOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderItemDao orderItemDao = new OrderItemDao();
        String orderId = request.getParameter("orderId");
        List<OrderItem> orderItemList = orderItemDao.queryOrderDetails(orderId);
        request.setAttribute("orderItemList",orderItemList);
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request,response);
    }

    protected void getOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        String orderId = request.getParameter("orderId");
        Order order = orderDao.getOrderById(orderId);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/pages/manager/confirm_order.jsp").forward(request,response);
    }

    protected void sendOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDao orderDao = new OrderDao();
        String orderId = request.getParameter("orderId");
        String createTime = request.getParameter("createTime");
        String price = request.getParameter("price");
        String status = request.getParameter("status");
        String userId = request.getParameter("userId");
        Order order = new Order(orderId,new Date(createTime),new BigDecimal(price),Integer.valueOf(status),Integer.valueOf(userId));
        orderDao.sendOut(order);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/OrderManageServlet?method=queryOrder").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");

        if("queryOrder".equals(method)){
            queryOrder(request,response);
        }else if("queryOrderDetails".equals(method)){
            queryOrderDetails(request,response);
        }else if("getOrderById".equals(method)){
            getOrderById(request,response);
        }
        else if("sendOut".equals(method)){
            sendOut(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
