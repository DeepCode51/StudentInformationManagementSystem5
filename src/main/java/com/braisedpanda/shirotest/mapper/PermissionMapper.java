package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.Role_Permission;
import com.braisedpanda.shirotest.bean.User_Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    //添加角色
    void addRole(Role role);
    //查询所有的权限信息
    List<Permission> getAllPermission();
    //根据权限id查出对应的权限
    Permission getPermissionById(String s1);
    //添加对应的角色-权限表
    void addRole_Permission(Role_Permission rp);
    //得到所有的角色
    List<Role> getAllRole();
    //根据uid查找出所有的角色
    List<User_Role> getRoleById(String uid);
    //根据roleid在表role中查询相应的role
    Role getRoleByRoleId(String roleid);
    //新增user_role信息
    void addUser_Role(User_Role user_role);
    //在表user_role中删除所有uid的角色
    void deleteRoleByUid(int uid);
    //查找所有的role_permission内容
    List<Role_Permission> getAllRole_Permission();
    //根据r_p_id删除角色所拥有的权限
    void deleteRolePermissionById(String r_p_id);
    //根据r_p_id查找role_permission对象
    List<Role_Permission> getRole_PermissionById(String r_p_id);

    //根据roleid删除role_permission表中所有的权限
    void deleteRolePermissionByRoleid(String roleid);
    //在role表中更新role的相关权限、名称等信息
    void updateRole(Role role);
    //根据roleid删除role表中的role
    void deleteRoleByRoleid(String roleid);
}
