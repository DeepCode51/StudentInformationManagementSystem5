package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.SClass;
import com.braisedpanda.shirotest.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassServiceImpl implements ClassService{
    @Autowired
    ClassMapper classMapper;
    @Override
    public void addClass(SClass sclass) {
        classMapper.addClass(sclass);
    }

    @Override
    public List<SClass> getAllClass() {
        List<SClass> classList = classMapper.getAllClass();
        return classList;
    }
    //根据classid值删除class

    @Override
    public void deleteClassById(String class_id) {
        classMapper.deleteClassById(class_id);
    }
    //根据classid查找出对应的class

    @Override
    public SClass getClassById(String class_id) {
        SClass sClass = classMapper.getClassById(class_id);
        return sClass;
    }

    //更新班级信息
     @Override
    public void updateClass(SClass sClass) {
        classMapper.updateClass(sClass);
    }


    ////获取所有的班级id


    @Override
    public List<String> getAllClassId() {
        List<String> list =  classMapper.getAllClassId();
        return list;
    }
}
