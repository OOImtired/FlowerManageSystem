package com.qst.dao;

import com.qst.bean.*;
import com.qst.utils.JdbcUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDao {


    public boolean saveOrder(Order order){
        /**
        * @描述:新建订单
        * @参数注释:
        * @param: order
        * @返回值:boolean
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="insert into t_order(order_id,create_time,price,status,user_id)" +
                " values(?,?,?,?,?)";
        return JdbcUtils.save(sql,order.getOrderId(),order.getCreateTime(),
                order.getPrice(),order.getStatus(),order.getUserId());
    }

    public List<Order> queryOrder(Integer userId){
        /**
        * @描述:通过订单id查找订单
        * @参数注释:
        * @param: userId
        * @返回值:java.util.List<com.qst.bean.Order>
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order where user_id=?";
        return JdbcUtils.getList(Order.class,sql,userId);
    }

    public List<Order> queryOrder(){
        /**
        * @描述:查找所有订单
        * @参数注释:
        * @param:
        * @返回值:java.util.List<com.qst.bean.Order>
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order";
        return JdbcUtils.getList(Order.class,sql);
    }

    public String createOrder(Cart cart,Integer userId){
        /**
        * @描述:创建订单号
        * @参数注释:
        * @param: cart
         * @param: userId
        * @返回值:java.lang.String
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        OrderDao orderDao =new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        FlowerDao flowerDao = new FlowerDao();
        //订单号，唯一
        String orderId=System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        //遍历购物车中的每一个商品项，转换为订单项保存
        for (Map.Entry<Integer, CartItem> entry:
             cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getTradeName(),cartItem.getTradeCount(),cartItem.getTradePrice(),cartItem.getTradeTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            Flower flower = flowerDao.queryFlowerById(cartItem.getId());
            flower.setFlowerSales(flower.getFlowerSales() + cartItem.getTradeCount());
            flowerDao.updateFlower(flower);
        }
        cart.clear();
        return orderId;
    }

    public Order getOrderById(String id){
        /**
        * @描述:通过订单id获取订单
        * @参数注释:
        * @param: id
        * @返回值:com.qst.bean.Order
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order where order_id =?";
        return JdbcUtils.getSingleObj(Order.class,sql,id);
    }

    public boolean sendOut(Order order){
        /**
        * @描述:发货操作
        * @参数注释:
        * @param: order
        * @返回值:boolean
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="update t_order set status = 1, price = ? where order_id = ?";
        return JdbcUtils.update(sql,order.getPrice(),order.getOrderId());
    }

}
