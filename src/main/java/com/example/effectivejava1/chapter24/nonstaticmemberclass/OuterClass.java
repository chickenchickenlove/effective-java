package com.example.effectivejava1.chapter24.nonstaticmemberclass;

// ITEM24 : 비정적 멤버 클래스
public class OuterClass {

    private int number = 10;

    void prinNumber() {
        // 주로 이런 형태로 OuterClass 내부에서 생성한 후 작업한다.
        InnerClass innerClass = new InnerClass();
    }

    // 비정적 멤버 클래스
    private class InnerClass {
        void doSomething() {
            System.out.println(number);
            // 비정적 멤버 클래스는 바깥 클래스 생성 후, 생성되기 때문에 묵시적 참조 가능
            OuterClass.this.prinNumber();
        }
    }

    public static void main(String[] args) {
        // 주로 이렇게는 사용하지 않음.
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.doSomething();
    }
}
