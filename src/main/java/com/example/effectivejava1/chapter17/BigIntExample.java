package com.example.effectivejava1.chapter17;

import java.util.HashSet;
import java.util.Set;

public class BigIntExample {

    public static void main(String[] args) {

        // Point가 불변 클래스면, Set도 불변 클래스에 가깝다.
        final Set<Point> points = new HashSet<>();
        Point firstPoint = new Point(1, 2);
        points.add(firstPoint);

        // 이 경우, Point는 불변 클래스가 아니게 된다.
        // firstPoint.x = 10;
    }
}
