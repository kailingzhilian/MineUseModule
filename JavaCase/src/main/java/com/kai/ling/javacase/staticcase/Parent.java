package com.kai.ling.javacase.staticcase;

/**
 * Created by kai.wang
 * on 2018/9/3 0003.
 */

public class Parent {
    public static int sPrentValue = 1;

    public static void parentMethod(int value) {
        System.out.print("parentMethod--parent -" + value);
    }
}
