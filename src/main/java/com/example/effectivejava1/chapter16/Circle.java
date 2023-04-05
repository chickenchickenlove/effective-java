package com.example.effectivejava1.chapter16;

public class Circle {

    public Circle() {
        Point point = new Point();
        point.setX(5);
    }

    private class Point {
        private double x, y;


        public void setX(double x) {
            assert x > 5;
            this.x = x;
        }
        public double getX() {
            System.out.println("add-on function");
            return this.x;
        }
    }
}
