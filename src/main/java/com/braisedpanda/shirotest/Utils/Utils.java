package com.braisedpanda.shirotest.Utils;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.util.StringUtil;

import java.math.BigDecimal;
import java.util.List;

public class Utils {
    //获取一个数组的最大值
    public double getMax(List<Double> list){
        if(list!=null && list.size()>0) {
            double max = list.get(0);
            for (Double d :
                    list) {
                if (max < d) {
                    max = d;
                }
            }
            return max;
        }
        return -1;
    }
    //获取一个数组中的最小值
    public double getMin(List<Double> list){
        if(list!=null && list.size()>0){
            double min = list.get(0);
            for (Double d:
                    list) {
                if(min>d){
                    min = d;
                }
            }
            return min;
        }
        return -1;
    }

    //获取一个数组的平均值
    public double getAver(List<Double> list){
        double aver = 0;
        for (double d:
             list) {
            aver = aver + d;
        }
        aver = aver / list.size();
        String st = String.format("%.0f", aver);

        double s2 = Double.parseDouble(st);

        return  s2;
    }

}
