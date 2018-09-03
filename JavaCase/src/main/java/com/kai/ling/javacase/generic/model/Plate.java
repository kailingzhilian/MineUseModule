package com.kai.ling.javacase.generic.model;

public class Plate<T>{
    private T item;
    public Plate(T t){item=t;}
    public void set(T t){item=t;}
    public T get(){return item;}
}