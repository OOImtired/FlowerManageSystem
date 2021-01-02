package com.qst.dao;

import com.qst.bean.Order;
import com.qst.bean.OrderItem;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class OrderItemDao {

    public boolean saveOrderItem(OrderItem orderItem){
        String sql="insert into t_order_item(name,count,price,total_price,order_id)" +
                " values(?,?,?,?,?)";
        return JdbcUtils.save(sql,orderItem.getName(),orderItem.getCount(),
                orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    public List<OrderItem> queryOrderDetails(String orderId){
        String sql = "select name,count,price,total_price totalPrice,order_id orderId " +
                "from t_order_item " +
                "where order_id = ? ";
        return JdbcUtils.getList(OrderItem.class,sql,orderId);
    }


}