package com.example.effectivejava1.chapter26.unbounded;

import java.util.HashSet;
import java.util.Set;

public class TypeNumbers {

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s2) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<?> MySet = set;


        System.out.println(TypeNumbers.numElementsInCommon(
                Set.of(1,2,3),
                Set.of(1,2)));
    }
}
