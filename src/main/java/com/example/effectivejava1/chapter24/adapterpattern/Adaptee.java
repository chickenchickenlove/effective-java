package com.example.effectivejava1.chapter24.adapterpattern;

import java.util.UUID;

// Adaptee는 이미 개발이 완료됐고, 수정하기 곤란한 상황이다.
public class Adaptee {
    public String request() {
        return UUID.randomUUID().toString();
    }

    // MyAdapter는 다음 특징을 가짐
    // 1. Adaptee의 Wrapper 클래스
    // 2. 클라이언트가 원하는 Target 인터페이스를 구현함.
    private class MyAdapter implements Target {

        private final Adaptee adaptee;

        public MyAdapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public String doRequest() {
            return adaptee.request();
        }
    }
}
