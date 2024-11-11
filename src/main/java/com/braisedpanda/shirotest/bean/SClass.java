package com.braisedpanda.shirotest.bean;

import java.io.Serializable;
import java.util.List;

public class SClass implements Serializable{
    private String class_id;                //班级id
    private String class_name;              //班级名称
    private String class_teacher;           //班主任
    private int class_count;             //班级总人数
    private String chinese_teacher;         //语文老师
    private String mathematics_teacher;     //数学老师
    private String english_teacher;         //英语老师
    private String politics_teacher;        //政治老师
    private String history_teacher;         //历史老师
    private String geography_teacher;       //地理老师
    private String biology_teacher;         //生物老师
    private String chemistry_teacher;       //化学老师
    private String physics_teacher;         //物理老师
    private String music_teacher;           //音乐老师
    private String arts_teacher;            //美术老师
    private String sports_teacher;          //体育老师
    private List<Student> studentList;      //班级全部的学生

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    public int getClass_count() {
        return class_count;
    }

    public void setClass_count(int class_count) {
        this.class_count = class_count;
    }

    public String getChinese_teacher() {
        return chinese_teacher;
    }

    public void setChinese_teacher(String chinese_teacher) {
        this.chinese_teacher = chinese_teacher;
    }

    public String getMathematics_teacher() {
        return mathematics_teacher;
    }

    public void setMathematics_teacher(String mathematics_teacher) {
        this.mathematics_teacher = mathematics_teacher;
    }

    public String getEnglish_teacher() {
        return english_teacher;
    }

    public void setEnglish_teacher(String english_teacher) {
        this.english_teacher = english_teacher;
    }

    public String getPolitics_teacher() {
        return politics_teacher;
    }

    public void setPolitics_teacher(String politics_teacher) {
        this.politics_teacher = politics_teacher;
    }

    public String getHistory_teacher() {
        return history_teacher;
    }

    public void setHistory_teacher(String history_teacher) {
        this.history_teacher = history_teacher;
    }

    public String getGeography_teacher() {
        return geography_teacher;
    }

    public void setGeography_teacher(String geography_teacher) {
        this.geography_teacher = geography_teacher;
    }

    public String getBiology_teacher() {
        return biology_teacher;
    }

    public void setBiology_teacher(String biology_teacher) {
        this.biology_teacher = biology_teacher;
    }

    public String getChemistry_teacher() {
        return chemistry_teacher;
    }

    public void setChemistry_teacher(String chemistry_teacher) {
        this.chemistry_teacher = chemistry_teacher;
    }

    public String getPhysics_teacher() {
        return physics_teacher;
    }

    public void setPhysics_teacher(String physics_teacher) {
        this.physics_teacher = physics_teacher;
    }

    public String getMusic_teacher() {
        return music_teacher;
    }

    public void setMusic_teacher(String music_teacher) {
        this.music_teacher = music_teacher;
    }

    public String getArts_teacher() {
        return arts_teacher;
    }

    public void setArts_teacher(String arts_teacher) {
        this.arts_teacher = arts_teacher;
    }

    public String getSports_teacher() {
        return sports_teacher;
    }

    public void setSports_teacher(String sports_teacher) {
        this.sports_teacher = sports_teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "SClass{" +
                "class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", class_teacher='" + class_teacher + '\'' +
                ", class_count='" + class_count + '\'' +
                ", chinese_teacher='" + chinese_teacher + '\'' +
                ", mathematics_teacher='" + mathematics_teacher + '\'' +
                ", english_teacher='" + english_teacher + '\'' +
                ", politics_teacher='" + politics_teacher + '\'' +
                ", history_teacher='" + history_teacher + '\'' +
                ", geography_teacher='" + geography_teacher + '\'' +
                ", biology_teacher='" + biology_teacher + '\'' +
                ", chemistry_teacher='" + chemistry_teacher + '\'' +
                ", physics_teacher='" + physics_teacher + '\'' +
                ", music_teacher='" + music_teacher + '\'' +
                ", arts_teacher='" + arts_teacher + '\'' +
                ", sports_teacher='" + sports_teacher + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
