package com.qst.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class JdbcUtils {

    static DataSource dataSource;

    static {
        //读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/jdbc.properties");
        Properties properties=new Properties();
        try {
            properties.load(in);
            dataSource=DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }

    public static <T> List<T> getList(Class<T> clazz, String sql, Object...args)  {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> userList=null;
        try{
            conn= JdbcUtils.getConnection();
//        String sql="select id,username,birthday from users where id=? and username=?";
//        String sql="select id,username,birthday from users";
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }


            rs=ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取当前结果集的列数
            int colnum= rsmd.getColumnCount();

            userList=new ArrayList<>();

            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放了一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colnum;i++){
                    String columnName= rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);

                    if(columnValue instanceof java.sql.Date){
                        java.sql.Date date=(java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }

                //创建一个User对象，给这个user对象属性赋值；
                T bean= clazz.newInstance();

                for(Map.Entry<String,Object> entry:rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue= entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }

                userList.add(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }


        return userList;
    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //保存对象方法
    public static boolean save( String sql, Object...args)  {
        Connection conn=null;
        PreparedStatement ps=null;
        Integer count=null;
        try{
            conn= JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }


            //返回更新的记录数
            count=ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps,null);
        }


        return count!=null&&count>0?true:false;
    }

    public static <T> T getSingleObj(Class<T> clazz, String sql, Object...args)  {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        T bean=null;
        try{
            conn= JdbcUtils.getConnection();
//        String sql="select id,username,birthday from users where id=? and username=?";
//        String sql="select id,username,birthday from users";
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }


            rs=ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取当前结果集的列数
            int colnum= rsmd.getColumnCount();


            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放了一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colnum;i++){
                    String columnName= rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);

                    if(columnValue instanceof java.sql.Date){
                        java.sql.Date date=(java.sql.Date)columnValue;
                        columnValue=new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }

                //创建一个User对象，给这个user对象属性赋值；
                bean= clazz.newInstance();

                for(Map.Entry<String,Object> entry:rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue= entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return bean;
    }

    //查询记录数量
    public static Integer getCount(String sql, Object...args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer count=0;
        try{
            conn= JdbcUtils.getConnection();
//        String sql="select id,username,birthday from users where id=? and username=?";
            ps = conn.prepareStatement(sql);


            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){
                    ps.setObject(i+1,args[i]);
                }
            }


            rs=ps.executeQuery();

            while(rs.next()){

                count=rs.getInt(1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return count;
    }

    //更新操作
    public static boolean update(String sql, Object...args)  {
        Connection conn=null;
        PreparedStatement ps=null;
        Integer count = 0;
        try{
            conn= JdbcUtils.getConnection();
//        String sql="select id,username,birthday from users where id=? and username=?";
//        String sql="select id,username,birthday from users";
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){

                    //判断当前类型，是不是java.util.Date,转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date=(java.util.Date)args[i];
                        args[i] = new java.sql.Date(date.getTime());
                    }

                    ps.setObject(i+1,args[i]);
                }
            }


            count=ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, null);
        }
        return count>0?true:false;
    }

    //更新操作
    public static Integer updateForPrimary(String sql, Object...args)  {
        Connection conn=null;
        PreparedStatement ps=null;
        Integer primaryKey=null;
        ResultSet rs=null;
        try{
            conn= JdbcUtils.getConnection();
//        String sql="select id,username,birthday from users where id=? and username=?";
//        String sql="select id,username,birthday from users";
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            if(args!=null&&args.length>0){
                for(int i=0;i<args.length;i++){

                    //判断当前类型，是不是java.util.Date,转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date=(java.util.Date)args[i];
                        args[i] = new java.sql.Date(date.getTime());
                    }

                    ps.setObject(i+1,args[i]);
                }
            }

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                primaryKey = (Integer) rs.getInt(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return primaryKey;
    }

}
