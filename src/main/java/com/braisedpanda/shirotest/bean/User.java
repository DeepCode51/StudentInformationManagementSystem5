package com.braisedpanda.shirotest.bean;

import java.io.Serializable;


public class User implements Serializable{
    private int uid;
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String gender;
    private String activecode;
    private String images;
    private String roleList;

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", activecode='" + activecode + '\'' +
                ", images='" + images + '\'' +
                ", roleList='" + roleList + '\'' +
                '}';
    }
}
