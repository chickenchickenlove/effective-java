package com.example.effectivejava1.chapter30._02_after;

import java.util.HashSet;
import java.util.Set;

// Generic Union 메서드의 테스트 프로그램 (177쪽)
// 유틸리티 클래스 Union
public class Union {

    // 유틸리티 메서드 union()
    // 코드 30-2 제네릭 메서드 (177쪽)
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> all = union(guys, stooges);

        // 이렇게 할 경우 컴파일 에러 발생
        // Set<Integer> stooges = Set.of(1, 2, 3);
        // Set<String> all = union(guys, stooges);

        for (String o : all) {
            System.out.println(o); // 캐스팅 하지 않아도 됨.
        }
    }
}
