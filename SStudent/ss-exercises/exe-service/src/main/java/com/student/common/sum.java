package com.student.common;

import java.security.PublicKey;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * 生成算术题
 */
public class sum {

    public static void main(String[] args) {
        Random random = new Random();
        getPlus(random);
        getMinus(random);
        getRide(random);
        getDivide(random);
    }

    //加
    private static void getPlus(Random random){
        for (int i = 1; i < 10; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            System.out.println(a + " + " + b + " =");
        }
    }
    //减
    public static void getMinus(Random random){
        for (int i = 1; i < 10; i++) {
            int a = random.nextInt(100)+1;
            int b = random.nextInt(50)+1;
            System.out.println(a + " - " + b + " =");
        }
    }
    //乘
    public static void getRide(Random random){
        for (int i = 1; i < 5; i++) {
            int a = random.nextInt(20)+1;
            int b = random.nextInt(20)+1;
            System.out.println(a + " × " + b + " =");
        }
    }
    //除
    public static void getDivide(Random random){
        for (int i = 1; i < 5; i++) {
            int a = random.nextInt(60)+1;
            int b = random.nextInt(20)+1;
            System.out.println(a + " ÷ " + b + " =");
        }
    }
}
