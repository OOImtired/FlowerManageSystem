package com.qst.dao;

import com.qst.bean.Flower;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class FlowerDao {

    public boolean addFlower(Flower flower){
        String sql ="insert into t_flower(flower_name,flower_price,flower_hot,flower_introduction,flower_sales,img_path)" +
                " values(?,?,?,?,?,?)";
        return JdbcUtils.save(sql,flower.getFlowerName(),flower.getFlowerPrice(), flower.getFlowerHot(),
                flower.getFlowerIntroduction(),flower.getFlowerSales(),flower.getImgPath());
    }

    public boolean deleteFlower(Integer id){
        String sql="delete from t_flower where id = ?";
        boolean flag=JdbcUtils.update(sql,id);
        return flag;
    }

    public boolean updateFlower(Flower flower){
        String sql="update t_flower set flower_name = ?, flower_price = ?, flower_hot = ?," +
                " flower_introduction = ?, flower_sales = ?, img_path = ? where id = ?";
        boolean flag=JdbcUtils.update(sql,flower.getFlowerName(),flower.getFlowerPrice(), flower.getFlowerHot(),
                flower.getFlowerIntroduction(),flower.getFlowerSales(),flower.getImgPath(),flower.getId());
        return flag;
    }

    public Flower queryFlowerById(Integer id){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath " +
                "from t_flower " +
                "where id=?";
        Flower flower = JdbcUtils.getSingleObj(Flower.class,sql,id);
        return flower;
    }

    public List<Flower> queryFlower(){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath " +
                "from t_flower";
        return JdbcUtils.getList(Flower.class,sql);
    }

    public void updatePic(Integer id, String imgPath) {
        String sql = "update t_flower set img_path = ? where id = ?";
        JdbcUtils.update(sql,imgPath,id);
    }

}
