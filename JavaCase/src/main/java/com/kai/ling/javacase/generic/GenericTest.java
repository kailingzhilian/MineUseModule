package com.kai.ling.javacase.generic;

import com.kai.ling.javacase.generic.model.Apple;
import com.kai.ling.javacase.generic.model.Fruit;
import com.kai.ling.javacase.generic.model.Plate;

/**
 * Created by kai.wang
 * on 2018/9/3 0003.
 */

public class GenericTest {


    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

        //不能存入任何元素
//        p.set(new Fruit());    //Error
//        p.set(new Apple());    //Error

        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1 = p.get();
        Object newFruit2 = p.get();
//        Apple newFruit3 = p.get();    //Error

    }
}
