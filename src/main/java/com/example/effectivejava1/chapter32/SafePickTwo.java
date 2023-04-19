package com.example.effectivejava1.chapter32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// 배열 대신 List를 이용해 안전하게 바뀐 PickTwo (196쪽)
public class SafePickTwo {

    static <T> List<T> pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a,b);
            case 1: return List.of(a, c);
            case 2: return List.of(b,c);
        }
        throw new AssertionError(); // 도달할 수 없다.
    }

    public static void main(String[] args) { // 194쪽
        List<String> attributes = pickTwo("좋은", "빠른", "저렴한");
        System.out.println(attributes);
    }
}
