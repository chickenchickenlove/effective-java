package com.example.effectivejava1.chapter23.hierarchy;

public class Square extends Figure{

    final double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return width * width;
    }
}
