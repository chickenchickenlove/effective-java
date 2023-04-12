package com.example.effectivejava1.chapter22;

// 코드 22-1 상수 인터페이스 안티패턴 - 사용금지! (139쪽)
public class MyClass implements PhysicalConstants{
    public static void main(String[] args) {
        PhysicalConstants myClass = new MyClass();
    }
}