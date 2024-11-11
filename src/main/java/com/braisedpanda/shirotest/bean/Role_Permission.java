package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Role_Permission implements Serializable{
    private String r_p_id;
    private String permissionid;
    private String permission;
    private String permission_describe;
    private String roleid;
    private String role;
    private String role_describe;

    public String getR_p_id() {
        return r_p_id;
    }

    public void setR_p_id(String r_p_id) {
        this.r_p_id = r_p_id;
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission_describe() {
        return permission_describe;
    }

    public void setPermission_describe(String permission_describe) {
        this.permission_describe = permission_describe;
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

    public String getRole_describe() {
        return role_describe;
    }

    public void setRole_describe(String role_describe) {
        this.role_describe = role_describe;
    }

    @Override
    public String toString() {
        return "Role_Permission{" +
                "r_p_id='" + r_p_id + '\'' +
                ", permissionid='" + permissionid + '\'' +
                ", permission='" + permission + '\'' +
                ", permission_describe='" + permission_describe + '\'' +
                ", roleid='" + roleid + '\'' +
                ", role='" + role + '\'' +
                ", role_describe='" + role_describe + '\'' +
                '}';
    }
}
