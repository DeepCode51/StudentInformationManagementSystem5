package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class StudentGradesCustom implements Serializable {

    /**
     * 学生成绩信息表
     */

    private String stu_id;
    private String stu_name;
    private String class_id;
    private String test_describe;
    private String test_time;
    private double total;
    private double average;
    private double maxscore;
    private double minscore;
    private double chinese;
    private double mathematics;
    private double english;
    private double politics;
    private double history;
    private double geography;
    private double biology;
    private double chemistry;
    private double physics;
    private double music;
    private double arts;
    private double sports;

    public String getTest_time() {
        return test_time;
    }

    public void setTest_time(String test_time) {
        this.test_time = test_time;
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

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getTest_describe() {
        return test_describe;
    }

    public void setTest_describe(String test_describe) {
        this.test_describe = test_describe;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMaxscore() {
        return maxscore;
    }

    public void setMaxscore(double maxscore) {
        this.maxscore = maxscore;
    }

    public double getMinscore() {
        return minscore;
    }

    public void setMinscore(double minscore) {
        this.minscore = minscore;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getPolitics() {
        return politics;
    }

    public void setPolitics(double politics) {
        this.politics = politics;
    }

    public double getHistory() {
        return history;
    }

    public void setHistory(double history) {
        this.history = history;
    }

    public double getGeography() {
        return geography;
    }

    public void setGeography(double geography) {
        this.geography = geography;
    }

    public double getBiology() {
        return biology;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getMusic() {
        return music;
    }

    public void setMusic(double music) {
        this.music = music;
    }

    public double getArts() {
        return arts;
    }

    public void setArts(double arts) {
        this.arts = arts;
    }

    public double getSports() {
        return sports;
    }

    public void setSports(double sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "StudentGradesCustom{" +
                "stu_id='" + stu_id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", test_describe='" + test_describe + '\'' +
                ", test_time='" + test_time + '\'' +
                ", total=" + total +
                ", average=" + average +
                ", maxscore=" + maxscore +
                ", minscore=" + minscore +
                ", chinese=" + chinese +
                ", mathematics=" + mathematics +
                ", english=" + english +
                ", politics=" + politics +
                ", history=" + history +
                ", geography=" + geography +
                ", biology=" + biology +
                ", chemistry=" + chemistry +
                ", physics=" + physics +
                ", music=" + music +
                ", arts=" + arts +
                ", sports=" + sports +
                '}';
    }
}
