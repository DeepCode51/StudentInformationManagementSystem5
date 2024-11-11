package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;

    //新增学生信息
    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    //查找所有学生
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentMapper.getAllStudent();
        return studentList;
    }

    //根据学生id删除学生
    @Override
    public void delete(String stu_id) {
        studentMapper.delete(stu_id);
    }

    //根据学校id查找学生
    @Override
    public Student getStudentById(String stu_id) {
      Student student =  studentMapper.getStudentById(stu_id);
      return student;
    }
    //更新学生信息
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
    //查询所有学生的班级
    @Override
    public List<String> getAllClass() {
        List<String> classIdlist = studentMapper.getAllClass();
        return classIdlist;
    }
    //根据班级id查找学生的总数

    @Override
    public int getStudentConutByCid(String classid) {
       int count =  studentMapper.getStudentCountByCid(classid);
       return count;
    }



    //根据班级的classid查找出该班的所有学生


    @Override
    public List<Student> getStudentByClassId(String class_id) {
        List<Student> list = studentMapper.getStudentByClassId(class_id);
        return list;
    }
}
