package com.qst.dao;

import com.qst.bean.Flower;
import com.qst.bean.Page;
import com.qst.utils.JdbcUtils;

import java.util.List;

public class PageDao {

    public static Integer queryForPageTotalCount(){
        /**
        * @描述:获取鲜花总数，以记录总数
        * @参数注释:
        * @param:
        * @返回值:java.lang.Integer
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select count(*) from t_flower";
        Number count = (Number) JdbcUtils.getCount(sql);
        return count.intValue();
    }

    public static List<Flower> queryForPageItems(int begin, int pageSize){
        /**
        * @描述:通过分页开始页和页面大小，展示鲜花
        * @参数注释:
        * @param: begin
         * @param: pageSize
        * @返回值:java.util.List<com.qst.bean.Flower>
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="select id, flower_name flowerName, flower_price flowerPrice," +
                " flower_hot flowerHot, flower_introduction flowerIntroduction," +
                " flower_sales flowerSales, img_path imgPath "+
                "from t_flower limit ?,?";
        return JdbcUtils.getList(Flower.class,sql,begin,pageSize);
    }

    public static Integer queryForPageTotalCountByPrice(double min, double max){
        /**
        * @描述:通过价格区间查询鲜花
        * @参数注释:
        * @param: min
         * @param: max
        * @返回值:java.lang.Integer
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="select count(*) from t_flower where flower_price between ? and ?";
        Number count = (Number) JdbcUtils.getCount(sql,min,max);
        return count.intValue();
    }

    public static List<Flower> queryForPageItemsByPrice(int begin, int pageSize, double min, double max){
        /**
        * @描述:通过开始页、页面大小、价格区间分页查询鲜花
        * @参数注释:
        * @param: begin
         * @param: pageSize
         * @param: min
         * @param: max
        * @返回值:java.util.List<com.qst.bean.Flower>
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
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
