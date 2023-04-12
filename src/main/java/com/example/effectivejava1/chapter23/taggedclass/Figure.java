package com.example.effectivejava1.chapter23.taggedclass;

// 코드 23-1 태그 달린 클래스 - 클래스 계층구조(상속)보다 훨씬 나쁘다! (142-143쪽)
public class Figure {

    enum Shape {RECTANGLE, CIRCLE}

    // 태그 필드 - 현재 모양을 나타낸다.
    final Shape shape;

    // 사각형일 때만 쓰인다
    double length;
    double width;

    // 원일 때만 쓰인다.
    double radius;

    // 원용 생성자
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형용 생성자
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }


    public static void main(String[] args) {
        // 이 Figure는 원? 사각형?
        Figure figure = new Figure(1,2);
    }


}
