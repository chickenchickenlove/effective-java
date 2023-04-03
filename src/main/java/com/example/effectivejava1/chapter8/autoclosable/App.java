package com.example.effectivejava1.chapter8.autoclosable;

public class App {
    public static void main(String[] args) {
        try (AutoClosableIsGood good = new AutoClosableIsGood();) {
            // TODO 자원 반납 처리가 됨.
        }
    }
}
