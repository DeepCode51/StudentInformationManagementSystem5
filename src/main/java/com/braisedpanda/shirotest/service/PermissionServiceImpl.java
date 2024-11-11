package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.Role_Permission;
import com.braisedpanda.shirotest.bean.User_Role;
import com.braisedpanda.shirotest.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    PermissionMapper permissionMapper;

    //添加角色信息
    @Override
    public void addRole(Role role) {
        permissionMapper.addRole(role);
    }

    //查询所有的权限信息

    @Override
    public List<Permission> getAllPermission() {
        List<Permission> permissionList = permissionMapper.getAllPermission();
        return permissionList;
    }
    //根据权限id查出对应的权限

    @Override
    public Permission getPermissionById(String s1) {
       Permission permission =  permissionMapper.getPermissionById(s1);
       return permission;
    }
    //添加对应的角色-权限表

    @Override
    public void addRole_Permission(Role_Permission rp) {
        permissionMapper.addRole_Permission(rp);
    }
    //查找所有的角色

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList = permissionMapper.getAllRole();
        return  roleList;
    }
    //根据uid查找出所有的角色

    @Override
    public List<User_Role> getRoleById(String uid) {
        List<User_Role> user_roleList =permissionMapper.getRoleById(uid);
       return user_roleList;
    }

    //根据roleid在role中查询相应的role

    @Override
    public Role getRoleByRoleId(String roleid) {
        Role role = permissionMapper.getRoleByRoleId(roleid);
        return role;
    }

    //新增user_role

    @Override
    public void addUser_Role(User_Role user_role) {
        permissionMapper.addUser_Role(user_role);
    }
    //在表User_Role中删除所有uid的角色

    @Override
    public void deleteRoleByUid(int uid) {
        permissionMapper.deleteRoleByUid(uid);
    }

    //查找所有的role_permission内容
    @Override
    public List<Role_Permission> getAllRole_Permission() {
        List<Role_Permission> role_permissionList = permissionMapper.getAllRole_Permission();
        return role_permissionList;
    }
    //根据r_p_id删除角色所拥有的权限

    @Override
    public void deleteRolePermissionById(String r_p_id) {
        permissionMapper.deleteRolePermissionById(r_p_id);
    }

    //根据r_p_id查找role_permission对象

    @Override
    public List<Role_Permission>  getRole_PermissionById(String r_p_id) {
        List<Role_Permission> role_permissionlist  = permissionMapper.getRole_PermissionById(r_p_id);
        return role_permissionlist;
    }
    //根据roleid删除role_permission表中所有的权限
    @Override
    public void deleteRolePermissionByRoleid(String roleid) {
        permissionMapper.deleteRolePermissionByRoleid(roleid);
    }

    //在role表中更新role的相关权限、名称等信息

    @Override
    public void updateRole(Role role) {
        permissionMapper.updateRole(role);
    }

    //根据roleid删除role表中的role

    @Override
    public void deleteRoleByRoleid(String roleid) {
        permissionMapper.deleteRoleByRoleid(roleid);
    }
}
