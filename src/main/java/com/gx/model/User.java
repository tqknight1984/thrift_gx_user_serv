package com.gx.model;

/**
 * Created by app on 16/9/1.
 */

public class User {
    private String username;
    private String pwd;
    private int id;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.pwd = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + pwd + "]";
    }

}