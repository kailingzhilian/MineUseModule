package com.kai.ling.javacase.staticcase;

/**
 * Created by kai.wang
 * on 2018/9/3 0003.
 */

public class StaticTest {

    public static void main(String[] args) {
        Child.parentMethod(Child.sPrentValue);

        Parent parent = new Child();
        parent.parentMethod(Child.sPrentValue);
    }
}
