package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradesMapper {


    void add(Student_Grades_Card card);

    List<Student_Grades_Card> getGradesCard(String stu_id);

    void addGrades(Student_Grades student_grades);

    Student_Grades getGrades(String stu_grades_card_id);

    List<StudentGradesCustom> getStuGradesByStuID(String stu_id);
    //获取部分的学生成绩卡信息(只获取考试时间和考试描述)
    List<Student_Grades_Card> getSGCard();
    //批量生成学生成绩卡
    void addClass_Grades_Card(Class_Grades_Card cgcrad);
    //获取所有的班级成绩卡
    List<Class_Grades_Card> getAllClass_Grades_Card();

    Student_Grades_Card getGradesCardById_and_DesCribe(@Param("stu_id") String stu_id,@Param("test_describe") String time_describe);

    void addClass_Grades(Class_Grades class_grades);
    //查找所有的班级成绩
    List<Class_Grades> getAllClass_Grades();
    //根据id查找班级成绩卡
    Class_Grades_Card getClass_Grades_CardByID(String class_grades_card_id);
}
