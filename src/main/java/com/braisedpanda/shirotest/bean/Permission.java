package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Permission implements Serializable {

    private String permissionid;
    private String permission;
    private String permission_describe;

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


    @Override
    public String toString() {
        return "Permission{" +
                "permissionid='" + permissionid + '\'' +
                ", permission='" + permission + '\'' +
                ", permission_describe='" + permission_describe + '\'' +
                '}';
    }


}
