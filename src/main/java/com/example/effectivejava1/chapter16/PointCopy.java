package com.example.effectivejava1.chapter16;

public class PointCopy {
    public double x, y;

    public static void main(String[] args) {
        PointCopy point = new PointCopy();
        point.x = 10;
        point.y = 20;

        // doSomething 이후 값이 바뀔 수도 있음.
        doSomething(point);

        System.out.println(point.x);
        System.out.println(point.y);
    }

    public static void doSomething(PointCopy pointCopy) {
        // 객체 복사 → 성능 문제 야기
        PointCopy localPoint = new PointCopy();
        localPoint.x = pointCopy.x;
        localPoint.y = pointCopy.y;

        // 아래 비즈니스 로직
    }

}
