package com.example.effectivejava1.chapter16;

// 코드 16-2 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다. (102쪽)
public class Point {
    /*public double x, y;

    public static void main(String[] args) {
        Point point = new Point();
        point.x = 10;
        point.y = 20;

        assert point.x > 5;

        System.out.println(point.x);
        System.out.println(point.y);
    }*/

    private double x, y;
    public static void main2(String[] args) {
        Point point = new Point();
        point.setX(5);

        System.out.println(point.getX());
    }

    public void setX(double x) {
        assert x > 5;
        this.x = x;
    }
    public double getX() {
        System.out.println("add-on function");
        return this.x;
    }
}
