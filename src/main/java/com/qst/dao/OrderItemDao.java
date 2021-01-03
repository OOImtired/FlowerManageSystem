package com.qst.dao;

import com.qst.bean.Order;
import com.qst.bean.OrderItem;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class OrderItemDao {

    public boolean saveOrderItem(OrderItem orderItem){
        /**
        * @描述:增加具体订单项
        * @参数注释:
        * @param: orderItem
        * @返回值:boolean
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="insert into t_order_item(name,count,price,total_price,order_id)" +
                " values(?,?,?,?,?)";
        return JdbcUtils.save(sql,orderItem.getName(),orderItem.getCount(),
                orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    public List<OrderItem> queryOrderDetails(String orderId){
        /**
        * @描述:通过订单号查找具体订单项
        * @参数注释:
        * @param: orderId
        * @返回值:java.util.List<com.qst.bean.OrderItem>
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select name,count,price,total_price totalPrice,order_id orderId " +
                "from t_order_item " +
                "where order_id = ? ";
        return JdbcUtils.getList(OrderItem.class,sql,orderId);
    }


}
