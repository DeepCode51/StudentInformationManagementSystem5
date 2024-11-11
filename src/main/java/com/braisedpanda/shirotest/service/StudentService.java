package com.braisedpanda.shirotest.service;


import com.braisedpanda.shirotest.bean.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentService {

    @CacheEvict(value="student",allEntries = true,key="'addStudent:'+#student.stu_id")
    void addStudent(Student student);



    List<Student> getAllStudent();
    @CacheEvict(value = "student" ,allEntries = true,key="'delete:'+#stu_id")
    void delete(String stu_id);

    @Cacheable(value="student" , key="'getStudentById:'+#stu_id")
    Student getStudentById(String stu_id);

    @CacheEvict(value="student",allEntries = true, key="'updateStudent:'+#student.stu_id")
    void updateStudent(Student student);


    List<String> getAllClass();

    @Cacheable(value="student" ,key="'getStudentConutByCid:'+#classid")
    int getStudentConutByCid(String classid);
    //根据班级id值获取所有的学生
    @Cacheable(value="student", key="'getStduentByClassId:'+#class_id")
    List<Student> getStudentByClassId(String class_id);
}
