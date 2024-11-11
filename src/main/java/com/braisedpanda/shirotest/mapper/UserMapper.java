package com.braisedpanda.shirotest.mapper;


import com.braisedpanda.shirotest.bean.Role;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.bean.User_Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    //查找所有的用户
    List<User> getAllUser();
    //添加用户
    void addUser(User user);
    //根据用户名、密码查找用户
    User getUser(@Param("username") String username, @Param("password") String password);

    void delete(String uid);

    User getUserByUid(int uid);

    void edit(User user);


    List<User_Role> getRole(int uid);

    List<String> getPermission(String uid);
}
