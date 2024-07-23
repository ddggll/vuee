package com.example.springboot.algorithm;

/*
 * Created with IntelliJ IDEA.
 * @Author: lz
 * @Date: 2024/07/14/下午7:04
 * @Description:
 */

/**
 * @author lz
 */
public class ElectricityCalculation 
{
    /**
     * 计算电器的耗电量  
     *
     * @param power 电器的功率，单位：瓦特（W）  
     * @param hours 运行时间，单位：小时（h）  
     * @return 耗电量，单位：度  
     */
    public static double calculateConsumption(double power, double hours) {
        // 耗电量 = 功率 * 运行时间 / 1000（因为1千瓦时 = 1度）  
        return power * hours / 1000;
    }

    public static void main(String[] args) {
        // 示例：计算一个60W的电灯泡运行10小时的耗电量  
        double power = 9; // 功率，单位：瓦特  
        double hours = 10; // 运行时间，单位：小时  
        System.out.println("功率为：" + power + "瓦，运行时间为：" + hours + "小时");

        double consumption = calculateConsumption(power, hours);

        System.out.println("耗电量为：" + consumption + "度");
    }
}