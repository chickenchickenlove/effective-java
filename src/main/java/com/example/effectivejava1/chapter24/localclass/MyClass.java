package com.example.effectivejava1.chapter24.localclass;

public class MyClass {

    private int number = 10;

    // 로컬 클래스 선언.
    void doSomething() {
        class LocalClass {
            private void printNumber() {
                System.out.println(number);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.printNumber();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.doSomething();
    }
}
