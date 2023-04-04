package com.example.effectivejava1.chapter8.outerclass;

import java.lang.reflect.Field;

public class OuterClass {

     static class InnerClass{ }

//    public class InnerClass{ }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
//        InnerClass innerClass = outerClass.new InnerClass();
         InnerClass innerClass = new InnerClass();
        System.out.println(innerClass);

        outerClass.printConstructor();
    }

    private void printConstructor() {
        Field[] declaredFields = InnerClass.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type: " + field.getType());
            System.out.println("field name: " + field.getName());
        }
    }
}
