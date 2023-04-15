package com.example.effectivejava1.chapter20.templatecallback;

import java.util.function.BiFunction;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("number.txt");
        System.out.println(fileProcessor.process(plus));
        System.out.println(fileProcessor.process(minus));
        System.out.println(fileProcessor.process(multiple));
    }

    public static BiFunction<Integer, Integer, Integer> plus = (a, b) -> a + b;
    public static BiFunction<Integer, Integer, Integer> minus = (a, b) -> a - b;
    public static BiFunction<Integer, Integer, Integer> multiple = (a, b) -> a * b;
}
