package com.qst.dao;

import com.qst.bean.Flower;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class FlowerDao {

    /**
     * @描述:添加鲜花操作
     * @参数注释:
     * @param: flower
     * @返回值:boolean
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public boolean addFlower(Flower flower){
        String sql ="insert into t_flower(flower_name,flower_price,flower_hot,flower_introduction,flower_sales,img_path)" +
                " values(?,?,?,?,?,?)";
        return JdbcUtils.save(sql,flower.getFlowerName(),flower.getFlowerPrice(), flower.getFlowerHot(),
                flower.getFlowerIntroduction(),flower.getFlowerSales(),flower.getImgPath());
    }

    /**
     * @描述:删除鲜花操作
     * @参数注释:
     * @param: id
     * @返回值:boolean
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public boolean deleteFlower(Integer id){
        String sql="delete from t_flower where id = ?";
        boolean flag=JdbcUtils.update(sql,id);
        return flag;
    }

    /**
     * @描述:修改鲜花操作
     * @参数注释:
     * @param: flower
     * @返回值:boolean
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public boolean updateFlower(Flower flower){
        String sql="update t_flower set flower_name = ?, flower_price = ?, flower_hot = ?," +
                " flower_introduction = ?, flower_sales = ?, img_path = ? where id = ?";
        boolean flag=JdbcUtils.update(sql,flower.getFlowerName(),flower.getFlowerPrice(), flower.getFlowerHot(),
                flower.getFlowerIntroduction(),flower.getFlowerSales(),flower.getImgPath(),flower.getId());
        return flag;
    }

    /**
     * @描述:通过鲜花id查找鲜花
     * @参数注释:
     * @param: id
     * @返回值:com.qst.bean.Flower
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public Flower queryFlowerById(Integer id){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath " +
                "from t_flower " +
                "where id=?";
        Flower flower = JdbcUtils.getSingleObj(Flower.class,sql,id);
        return flower;
    }

    /**
     * @描述:查找所有鲜花
     * @参数注释:
     * @param:
     * @返回值:java.util.List<com.qst.bean.Flower>
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public List<Flower> queryFlower(){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath " +
                "from t_flower";
        return JdbcUtils.getList(Flower.class,sql);
    }

    /**
     * @描述:上传鲜花图片路径
     * @参数注释:
     * @param: id
     * @param: imgPath
     * @返回值:void
     * @创建人:OOImtired
     * @创建时间:2021/1/3
     */
    public void updatePic(Integer id, String imgPath) {
        String sql = "update t_flower set img_path = ? where id = ?";
        JdbcUtils.update(sql,imgPath,id);
    }

}
