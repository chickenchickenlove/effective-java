package com.example.effectivejava1.chapter24.staticmemberclass;

// ITEM24 : 정적 멤버 클래스
public class OuterClass {

    private static int number = 10;

    // 정적 멤버 클래스
    static private class InnerClass {
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }
}
