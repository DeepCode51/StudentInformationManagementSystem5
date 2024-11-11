package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Class_Grades_Card implements Serializable{
    private String class_grades_card_id;
    private String class_id;
    private String test_time;
    private String test_describe;

    public String getClass_grades_card_id() {
        return class_grades_card_id;
    }

    public void setClass_grades_card_id(String class_grades_card_id) {
        this.class_grades_card_id = class_grades_card_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
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
        return "Class_Grades_Card{" +
                "class_grades_card_id='" + class_grades_card_id + '\'' +
                ", class_id='" + class_id + '\'' +
                ", test_time='" + test_time + '\'' +
                ", test_describe='" + test_describe + '\'' +
                '}';
    }
}
