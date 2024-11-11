package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradesServiceImpl implements GradesService{
    @Autowired
    GradesMapper gradesMapper;

    @Override
    public void add(Student_Grades_Card card) {
        gradesMapper.add(card);
    }

    @Override
    public List<Student_Grades_Card> getGradesCard(String stu_id) {
        List<Student_Grades_Card> cardList = gradesMapper.getGradesCard(stu_id);
        return cardList;

    }

    @Override
    public void addGrades(Student_Grades student_grades) {
        gradesMapper.addGrades(student_grades);
    }

    @Override
    public Student_Grades getGrades(String stu_grades_card_id) {
        Student_Grades student_grades = gradesMapper.getGrades(stu_grades_card_id);
        return student_grades;
    }

    @Override
    public List<StudentGradesCustom> getStuGradesByStuID(String stu_id) {
        List<StudentGradesCustom> sgcList = gradesMapper.getStuGradesByStuID(stu_id);

        return sgcList;
    }

    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
     @Override
    public List<Student_Grades_Card> getSGCard() {
         List<Student_Grades_Card> list =  gradesMapper.getSGCard();
         return list;
    }

    //批量生成学生成绩卡
    @Override
    public void addClass_Grades_Card(Class_Grades_Card cgcrad) {
        gradesMapper.addClass_Grades_Card(cgcrad);
    }


    //获取所有的班级成绩卡


    @Override
    public List<Class_Grades_Card> getAllClass_Grades_Card() {
        List<Class_Grades_Card> list = gradesMapper.getAllClass_Grades_Card();
        return list;
    }


    @Override
    public Student_Grades_Card getGradesCardById_and_DesCribe(String stu_id, String time_describe) {
        Student_Grades_Card card = gradesMapper.getGradesCardById_and_DesCribe(stu_id,time_describe);

        return card;
    }

    @Override
    public void addClass_Grades(Class_Grades class_grades) {
        gradesMapper.addClass_Grades(class_grades);
    }

    //查找所有的班级成绩

    @Override
    public List<Class_Grades> getAllClassGrades() {
        List<Class_Grades> list = gradesMapper.getAllClass_Grades();
        return list;
    }
    //根据id查找班级成绩卡

    @Override
    public Class_Grades_Card getClass_Grades_CardByID(String class_grades_card_id) {
       Class_Grades_Card card =  gradesMapper.getClass_Grades_CardByID(class_grades_card_id);
        return card;
    }
}
