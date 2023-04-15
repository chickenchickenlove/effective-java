package com.example.effectivejava1.chapter24.anonymousclass;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

// 코드 20-1 골격 구현을 사용해 완성한 구체 클래스 (133쪽)
public class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);


        // 익명 클래스
        // intArrayAsList() 메서드 Scope에 정의되고, 동시에 인스턴스가 생성됨.
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
