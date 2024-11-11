package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Student_Grades_Card implements Serializable {
    private String stu_grades_card_id;
    private String stu_id;
    private String test_time;
    private String test_describe;


    public String getStu_grades_card_id() {
        return stu_grades_card_id;
    }

    public void setStu_grades_card_id(String stu_grades_card_id) {
        this.stu_grades_card_id = stu_grades_card_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getTest_time() {
        return test_time;
    }

    public void setTest_time(String test_time) {
        this.test_time = test_time;
    }

    public String getTest_describe() {
        return test_describe;
    }

    public void setTest_describe(String test_describe) {
        this.test_describe = test_describe;
    }

    @Override
    public String toString() {
        return "Student_Grades_Card{" +
                "stu_grades_card_id='" + stu_grades_card_id + '\'' +
                ", stu_id='" + stu_id + '\'' +
                ", test_time='" + test_time + '\'' +
                ", test_describe='" + test_describe + '\'' +
                '}';
    }
}
