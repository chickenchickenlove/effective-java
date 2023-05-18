package com.example.effectivejava1.chapter17;

public class StringExample {

    public static void main(String[] args) {
        String name = "whiteship";

        // 가변 동반 클래스를 이용해서 불변 클래스의 인스턴스 생성 최소화.
        StringBuilder nameBuilder = new StringBuilder(name);
        nameBuilder.append("keesun");
    }
}
