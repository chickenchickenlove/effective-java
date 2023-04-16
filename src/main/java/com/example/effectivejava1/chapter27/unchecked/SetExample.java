package com.example.effectivejava1.chapter27.unchecked;

import java.util.HashSet;
import java.util.Set;


public class SetExample {

    // Unchecked Warnings 발생
    // Set / HashSet이 모두 Raw Type으로 선언되어 있기 때문임.
    public static void main(String[] args) {
        // Unchecked 경고 발생
        Set names = new HashSet();

        // UnChecked 경고 발생
        Set<String> strings = new HashSet();
    }

}
