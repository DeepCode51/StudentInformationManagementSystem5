package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.bean.User_Role;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface UserService {
    //查找所有的用户


    List<User> getAllUser();

    //添加用户

    @CacheEvict(value="users",key="'addUser:'+#user.uid",allEntries = true)
    void addUser(User user);

    //根据用户名和密码查找用户

    @Cacheable(value="users",key="'getUser:'+#username")
    User getUser(String username, String password);
    @CacheEvict(value="users",allEntries = true,key="'delete:'+#uid")
    void delete(String uid);
    @Cacheable(value="users" , key="'getUserByUid:'+#uid")
    User getUserByUid(int uid);

    @CacheEvict(value="users",allEntries = true,key="'edit:'+#user.uid")
    void edit(User user);


    @Cacheable(value="users" , key="'getRole:'+#uid")
    List<User_Role> getRole(int uid);

    @Cacheable(value="users" , key="'getPermission:'+#uid")
    List<String> getPermission(String uid);
}
