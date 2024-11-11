package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.SClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    void addClass(SClass sclass);

    List<SClass> getAllClass();

    //根据classid值删除class
    void deleteClassById(String class_id);
    //根据classid查找出class
    SClass getClassById(String class_id);
    //更新班级信息
    void updateClass(SClass sClass);
    //获取所有的班级id
    List<String> getAllClassId();
}
