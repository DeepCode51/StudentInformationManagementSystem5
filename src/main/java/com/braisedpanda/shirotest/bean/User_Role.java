package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class User_Role implements Serializable {
    private String u_r_id;

    private int uid;
    private String username;
    private String roleid;
    private String role;
    private String role_describe;

    public String getRole_describe() {
        return role_describe;
    }

    public void setRole_describe(String role_describe) {
        this.role_describe = role_describe;
    }

    public String getU_r_id() {
        return u_r_id;
    }

    public void setU_r_id(String u_r_id) {
        this.u_r_id = u_r_id;
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

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User_Role{" +
                "u_r_id='" + u_r_id + '\'' +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", roleid='" + roleid + '\'' +
                ", role='" + role + '\'' +
                ", role_describe='" + role_describe + '\'' +
                '}';
    }
}
