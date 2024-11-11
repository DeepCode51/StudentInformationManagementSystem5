package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.SClass;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ClassService {

    @CacheEvict(value="class",key="'addClass:'+#sclass.class_id",allEntries = true)
    void addClass(SClass sclass);





    List<SClass> getAllClass();
    //根据classid值删除class
    @CacheEvict(value="class" , key="'deleteClassById:'+#class_id")
    void deleteClassById(String class_id);
    //根据class查找对应的class
    @Cacheable(value="class" , key="'getClassById:'+#class_id")
    SClass getClassById(String class_id);
    //更新班级信息
    @CacheEvict(value = "class" , key="'updateClass:'+#sClass.class_id")
    void updateClass(SClass sClass);
    //获取所有的班级id
    @Cacheable(value = "class")
    List<String> getAllClassId();
}
