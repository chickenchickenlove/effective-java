package com.example.effectivejava1.chapter10.lombok;

public class LombokTest {

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point.equals(new Point(1, 2)));
    }
}
