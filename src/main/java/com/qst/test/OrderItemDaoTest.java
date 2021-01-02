package com.qst.test;

import com.qst.bean.OrderItem;
import com.qst.dao.OrderItemDao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDaoTest {

    @Test
    void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDao();
        System.out.println(orderItemDao.saveOrderItem(new OrderItem(null,"123",10,new BigDecimal(10),new BigDecimal(100),"123")));
    }

    @Test
    void queryOrderDetails(){
        OrderItemDao orderItemDao = new OrderItemDao();
        List<OrderItem> orderItem = orderItemDao.queryOrderDetails("16092460522368");

        System.out.println(orderItem);
        /*for (OrderItem o:orderItem
             ) {
            System.out.println(orderItem);
        }*/
    }


}