package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Nation implements Serializable{
    private String nation_id;
    private String nation_name;

    public String getNation_id() {
        return nation_id;
    }

    public void setNation_id(String nation_id) {
        this.nation_id = nation_id;
    }

    public String getNation_name() {
        return nation_name;
    }

    public void setNation_name(String nation_name) {
        this.nation_name = nation_name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "nation_id='" + nation_id + '\'' +
                ", nation_name='" + nation_name + '\'' +
                '}';
    }
}
