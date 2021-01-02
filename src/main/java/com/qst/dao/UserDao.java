package com.qst.dao;

import com.qst.bean.User;
import com.qst.utils.JdbcUtils;

public class UserDao {

    public boolean saveUser(User user){
        String sql = "insert into t_user(username,password,email,jurisdiction) values(?,?,?,?)";
        return JdbcUtils.save(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getJurisdiction());
    }

    public Integer selectUsernameCount(String username) {

        String sql="select count(*) from t_user a where a.username=?";
        Integer count=JdbcUtils.getCount(sql,username);
        return count;

    }

    public User getUserByUsernameAndPassword(String username,String password) {
        String sql="select * from t_user where username=? and password=?";
        return JdbcUtils.getSingleObj(User.class,sql,username,password);
    }


    public boolean existUsername(String username) {
        String sql = "select * from t_user where username=?";
        int count = JdbcUtils.getCount(sql,username);
        if(count == 0){
            return false;
        }
        return true;
    }
}
