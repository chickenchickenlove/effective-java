package com.example.effectivejava1.chapter21;

public interface MarkerInterface {

    default void hello() {
        System.out.println("hello interface");
    }
}
