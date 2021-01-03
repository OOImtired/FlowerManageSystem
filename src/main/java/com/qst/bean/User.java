package com.qst.bean;

/**
* @描述:用户类
* @创建人:OOImtired
* @创建时间:2021/1/3
*/

public class User {

    private Integer id;
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private Integer jurisdiction;//用户权限
    public User() {
    }

    public User(Integer id, String username, String password, String email, Integer jurisdiction) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.jurisdiction = jurisdiction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", jurisdiction=" + jurisdiction +
                '}';
    }
}
