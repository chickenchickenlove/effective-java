package com.example.effectivejava1.chapter7.weak;

import java.util.List;

public class StrongReferenceExample {

    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        array[1] = null;
    }

}
