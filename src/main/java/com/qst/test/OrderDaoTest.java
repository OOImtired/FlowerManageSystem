package com.qst.test;

import com.qst.bean.Cart;
import com.qst.bean.CartItem;
import com.qst.bean.Order;
import com.qst.bean.User;
import com.qst.dao.OrderDao;
import com.qst.dao.OrderItemDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {

    @Test
    void saveOrder() {
        OrderDao orderDao  =new OrderDao();
        orderDao.saveOrder(new Order("123",new Date(),new BigDecimal(20),1,8));
    }
    @Test
    void createOrder(){
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"1",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"2",1,new BigDecimal(100),new BigDecimal(100)));

        OrderDao orderDao = new OrderDao();
        System.out.println("订单号：" + orderDao.createOrder(cart,8));
    }
    @Test
    void queryOrder(){
        OrderDao orderDao = new OrderDao();
        List<Order> order = (List<Order>) orderDao.queryOrder(8);
        for (Order o:order
             ) {
            System.out.println(o);
        }
    }
    @Test
    void managerQueryOrder(){
        OrderDao orderDao = new OrderDao();
        List<Order> order = (List<Order>) orderDao.queryOrder();
        for (Order o:order
        ) {
            System.out.println(o);
        }
    }

    @Test
    void getOrderById(){
        OrderDao orderDao = new OrderDao();
        System.out.println(orderDao.getOrderById("16092469130368"));

    }

    @Test
    void sendOut(){
        OrderDao orderDao = new OrderDao();
/*
        System.out.println(orderDao.sendOut("16092469130368"));
*/
    }
}