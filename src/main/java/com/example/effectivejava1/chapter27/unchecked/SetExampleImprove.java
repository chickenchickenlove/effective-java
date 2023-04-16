package com.example.effectivejava1.chapter27.unchecked;

import java.util.HashSet;
import java.util.Set;


public class SetExampleImprove {

    public static void main(String[] args) {
        // Unchecked 경고 발생 → 좌측에 타입 선언, 우측에 다이아몬드 연산자 추가해서 해결
        Set<String> names = new HashSet<>();

        // UnChecked 경고 발생 → 오른쪽에 다이아몬드 연산자 추가해서 해결
        Set<String> strings = new HashSet<>();
    }

}
