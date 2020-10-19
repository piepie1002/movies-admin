package com.tact.movies.entity;

import java.util.Date;


public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private Date createDate;
    private Date expireDate;
    private long isVip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public long getIsVip() {
        return isVip;
    }

    public void setIsVip(long isVip) {
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + username + '\'' +
                ", userEmail='" + email + '\'' +
                ", userPasswd='" + password + '\'' +
                ", createDate=" + createDate +
                ", expireDate=" + expireDate +
                ", isVip=" + isVip +
                '}';
    }
}