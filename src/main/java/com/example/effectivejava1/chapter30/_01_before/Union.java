package com.example.effectivejava1.chapter30._01_before;

import java.util.HashSet;
import java.util.Set;

// Generic Union 메서드의 테스트 프로그램 (177쪽)
// 유틸리티 클래스 Union
public class Union {

    // 유틸리티 메서드 union()
    // 코드 30-2 제네릭 메서드 (177쪽)
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
    public static void main(String[] args) {
        Set guys = Set.of("톰", "딕", "해리");
        // Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set stooges = Set.of(1, 2, 3);
        Set all = union(guys, stooges);

        for (Object o : all) {
            System.out.println((String)o); // 런타임, classCastException 발생.
        }
    }
}
