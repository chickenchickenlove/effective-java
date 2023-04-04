package com.example.effectivejava1.chapter8.outerclass;

import java.lang.reflect.Field;

public class LambdaExample {

    private static int value = 10;

    private Runnable instanceLambda = () -> {
        System.out.println(value);
    };

    public static void main(String[] args) throws IllegalAccessException {
        LambdaExample example = new LambdaExample();
        Field[] declaredFields = example.instanceLambda.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field type: " + field.getType());
            System.out.println("field name: " + field.getName());
        }
    }
}
