package com.qst.dao;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class PageDao {

    public static Integer queryForPageTotalCount(){
        String sql = "select count(*) from t_flower";
        Number count = (Number) JdbcUtils.getCount(sql);
        return count.intValue();
    }

    public static List<Flower> queryForPageItems(int begin, int pageSize){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath "+
                "from t_flower limit ?,?";
        return JdbcUtils.getList(Flower.class,sql,begin,pageSize);
    }

    public static Integer queryForPageTotalCountByPrice(double min, double max){
        String sql="select count(*) from t_flower where flower_price between ? and ?";
        Number count = (Number) JdbcUtils.getCount(sql,min,max);
        return count.intValue();
    }

    public static List<Flower> queryForPageItemsByPrice(int begin, int pageSize, double min, double max){
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath "+
                "from t_flower where flower_price between ? and ? order by flower_price limit ?,?";
        return JdbcUtils.getList(Flower.class,sql,min,max,begin,pageSize);

    }

    Page<Flower> page = new Page<Flower>();

    public Page<Flower> page(int pageNo, int pageSize){
        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = PageDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);
        // 设置当前页码
        page.setPageNo(pageNo);
        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Flower> items = PageDao.queryForPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }

    public Page<Flower> pageByPrice(int pageNo, int pageSize, double min, double max) {
        Page<Flower> page = new Page<Flower>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = PageDao.queryForPageTotalCountByPrice(min,max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Flower> items = PageDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

}
