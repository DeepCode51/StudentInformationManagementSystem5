package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Student implements Serializable {

    private String stu_id;              //学生学号
    private String stu_name;            //姓名
    private String stu_password;        //密码
    private String stu_email;           //邮箱
    private String stu_id_card;         //身份证号码
    private String stu_sex;             //性别
    private String stu_birthday;        //生日
    private String nation_name;           //名族
    private String stu_status;          //入学状态
    private String stu_age;             //年龄
    private String class_id;            //班级标号
    private String stu_enrollment_time; //入学时间
    private String stu_political;       //政治面貌
    private String stu_address;         //家庭住址
    private String stu_image;           //相片



    private Nation nation;


    public String getNation_name() {
        return nation_name;
    }

    public void setNation_name(String nation_name) {
        this.nation_name = nation_name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_password() {
        return stu_password;
    }

    public void setStu_password(String stu_password) {
        this.stu_password = stu_password;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }

    public String getStu_id_card() {
        return stu_id_card;
    }

    public void setStu_id_card(String stu_id_card) {
        this.stu_id_card = stu_id_card;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public String getStu_birthday() {
        return stu_birthday;
    }

    public void setStu_birthday(String stu_birthday) {
        this.stu_birthday = stu_birthday;
    }





    public String getStu_status() {
        return stu_status;
    }

    public void setStu_status(String stu_status) {
        this.stu_status = stu_status;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStu_enrollment_time() {
        return stu_enrollment_time;
    }

    public void setStu_enrollment_time(String stu_enrollment_time) {
        this.stu_enrollment_time = stu_enrollment_time;
    }

    public String getStu_political() {
        return stu_political;
    }

    public void setStu_political(String stu_political) {
        this.stu_political = stu_political;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public String getStu_image() {
        return stu_image;
    }

    public void setStu_image(String stu_image) {
        this.stu_image = stu_image;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_password='" + stu_password + '\'' +
                ", stu_email='" + stu_email + '\'' +
                ", stu_id_card='" + stu_id_card + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_birthday='" + stu_birthday + '\'' +
                ", nation_name='" + nation_name + '\'' +
                ", stu_status='" + stu_status + '\'' +
                ", stu_age='" + stu_age + '\'' +
                ", class_id='" + class_id + '\'' +
                ", stu_enrollment_time='" + stu_enrollment_time + '\'' +
                ", stu_political='" + stu_political + '\'' +
                ", stu_address='" + stu_address + '\'' +
                ", stu_image='" + stu_image + '\'' +
                ", nation=" + nation +
                '}';
    }
}
