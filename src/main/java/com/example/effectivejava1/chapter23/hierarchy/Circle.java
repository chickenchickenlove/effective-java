package com.example.effectivejava1.chapter23.hierarchy;

public class Circle extends Figure{

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
