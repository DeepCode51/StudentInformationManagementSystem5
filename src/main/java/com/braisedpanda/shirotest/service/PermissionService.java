package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Permission;
import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.Role_Permission;
import com.braisedpanda.shirotest.bean.User_Role;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PermissionService {
    @CacheEvict(value="permission",key="'addRole:'+#role.roleid")
    void addRole(Role role);
    //获取所有的权限

    List<Permission> getAllPermission();

    //根据权限的id值，查询对应的权限
    @Cacheable(value="permission" , key="'getPermissionById:'+#s1")
    Permission getPermissionById(String s1);

    //添加对应的角色-权限表
    @CacheEvict(value="permission", key="'addRole_Permission:'+#rp.r_p_id")
    void addRole_Permission(Role_Permission rp);

    //查找所有的角色

    List<Role> getAllRole();
    //根据uid查找所有的角色
    @Cacheable(value = "permission" , key="'getRoleById:'+#uid")
    List<User_Role> getRoleById(String uid);
    //根据roleid查询role表中对应的role
    @Cacheable(value="permission" , key="'getRoleByRoleId:'+#roleid")
    Role getRoleByRoleId(String roleid);
    //新增user_role信息
    @CacheEvict(value="permission", key="'addUser_Role:'+#user_role.u_r_id")
    void addUser_Role(User_Role user_role);
    //删除user_role表中所有uid用户
    @CacheEvict(value="permission", key="'deleteRoleByUid:'+#uid",allEntries = true)
    void deleteRoleByUid(int uid);
    //查找所有的role_permission内容

    List<Role_Permission> getAllRole_Permission();
    //根据r_p_id删除角色所拥有的权限
    @CacheEvict(value="permission", key="'deleteRolePermissionById:'+#r_p_id",allEntries = true)
    void deleteRolePermissionById(String r_p_id);

    //根据r_p_id查找role_permission对象
    @Cacheable(value = "permission" , key="'getRole_PermissionById:'+#r_p_id")
    List<Role_Permission>  getRole_PermissionById(String r_p_id);
    //根据roleid删除role_permission表中所有的权限
    @CacheEvict(value="permission", key="'deleteRolePermissionByRoleid:'+#roleid",allEntries = true)
    void deleteRolePermissionByRoleid(String roleid);
    //在role表中更新role的相关权限、名称等信息
    @CacheEvict(value="permission", key="'updateRole:'+#role.roleid",allEntries = true)
    void updateRole(Role role);
    //根据roleid删除role表中的role
    @CacheEvict(value="permission" , key="'deleteRoleByRoleid:'+#roleid")
    void deleteRoleByRoleid(String roleid);
}
