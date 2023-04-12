package com.example.effectivejava1.chapter21;

public class SubClass extends SuperClass implements MarkerInterface{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.hello();
    }
}
