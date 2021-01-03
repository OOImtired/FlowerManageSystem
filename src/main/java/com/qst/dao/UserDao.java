package com.qst.dao;

import com.qst.bean.User;
import com.qst.utils.JdbcUtils;

public class UserDao {

    public boolean saveUser(User user){
        /**
        * @描述:用户注册
        * @参数注释:
        * @param: user
        * @返回值:boolean
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "insert into t_user(username,password,email,jurisdiction) values(?,?,?,?)";
        return JdbcUtils.save(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getJurisdiction());
    }

    public Integer selectUsernameCount(String username) {
        /**
        * @描述:通过姓名查询用户名是否存在
        * @参数注释:
        * @param: username
        * @返回值:java.lang.Integer
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="select count(*) from t_user a where a.username=?";
        Integer count=JdbcUtils.getCount(sql,username);
        return count;

    }

    public User getUserByUsernameAndPassword(String username,String password) {
        /**
        * @描述:通过用户名、密码判断是否登录成功
        * @参数注释:
        * @param: username
         * @param: password
        * @返回值:com.qst.bean.User
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql="select * from t_user where username=? and password=?";
        return JdbcUtils.getSingleObj(User.class,sql,username,password);
    }


    public boolean existUsername(String username) {
        /**
        * @描述:通过姓名查询用户名是否存在
        * @参数注释:
        * @param: username
        * @返回值:boolean
        * @创建人:OOImtired
        * @创建时间:2021/1/3
        */
        String sql = "select * from t_user where username=?";
        int count = JdbcUtils.getCount(sql,username);
        if(count == 0){
            return false;
        }
        return true;
    }
}
