package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Role implements Serializable{
    private String roleid;
    private String role;
    private String role_describe;

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

    public String getRole_describe() {
        return role_describe;
    }

    public void setRole_describe(String role_describe) {
        this.role_describe = role_describe;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", role='" + role + '\'' +
                ", role_describe='" + role_describe + '\'' +
                '}';
    }
}
