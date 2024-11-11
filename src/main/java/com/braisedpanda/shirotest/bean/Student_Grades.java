package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Student_Grades implements Serializable{
    private String stu_grades_id;
    private String stu_grades_card_id;
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

    public String getStu_grades_id() {
        return stu_grades_id;
    }

    public void setStu_grades_id(String stu_grades_id) {
        this.stu_grades_id = stu_grades_id;
    }

    public String getStu_grades_card_id() {
        return stu_grades_card_id;
    }

    public void setStu_grades_card_id(String stu_grades_card_id) {
        this.stu_grades_card_id = stu_grades_card_id;
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
        return "Student_Grades{" +
                "stu_grades_id='" + stu_grades_id + '\'' +
                ", stu_grades_card_id='" + stu_grades_card_id + '\'' +
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
