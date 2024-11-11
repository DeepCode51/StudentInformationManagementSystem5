package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GradesService {
    @CacheEvict(value="grades",allEntries = true,key="'add:'+#card.stu_grades_card_id")
    void add(Student_Grades_Card card);

    @Cacheable(value = "grades" , key="'getGradesCard:'+#stu_id")
    List<Student_Grades_Card> getGradesCard(String stu_id);
    @CacheEvict(value="grades",allEntries = true , key="'addGrades:'+#student_grades.stu_grades_id")
    void addGrades(Student_Grades student_grades);

    @Cacheable(value = "grades" , key="'getGrades:'+#stu_grades_card_id")
    Student_Grades getGrades(String stu_grades_card_id);

    @Cacheable(value = "grades" , key="'getStuGradesByStuID:'+#stu_id")
    List<StudentGradesCustom> getStuGradesByStuID(String stu_id);
    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<Student_Grades_Card> getSGCard();
    //批量生成学生成绩卡
    void addClass_Grades_Card(Class_Grades_Card cgcrad);
    //获取所有的班级成绩卡片
    @Cacheable(value="grades")
    List<Class_Grades_Card> getAllClass_Grades_Card();

    Student_Grades_Card getGradesCardById_and_DesCribe(String stu_id, String time_describe);

    void addClass_Grades(Class_Grades class_grades);
    //查找所有的班级成绩
    List<Class_Grades>  getAllClassGrades();
    //根据id查找班级成绩卡
    Class_Grades_Card getClass_Grades_CardByID(String class_grades_card_id);
}
