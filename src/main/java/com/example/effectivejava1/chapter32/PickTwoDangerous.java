package com.example.effectivejava1.chapter32;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// 미묘한 힙 오염 발생 (193-194쪽)
public class PickTwoDangerous {
    // 코드 32-2 자신의 제네릭 매개변수 배열의 참조를 노출한다. - 안전하지 않다! (193쪽)
    static <T> T[] toArray(T... args) {
        T[] args1 = args; // 타입 한정 매개변수 T는 포괄적임. 따라서 컴파일 환경에서 소거되고 Object[]로 전달됨.
        Object[] hello = args;
        hello[0] = 1;
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a,b);
            case 1: return toArray(a,c);
            case 2: return toArray(b,c);
        }
        throw new AssertionError(); // 도닥할 수 없다.
    }

    public static void main(String[] args) { // 194쪽
        // pickTwo의 결과로 Object[]을 전달받음. 여기서 String[]으로 classCast를 해야함.
        // 그런데 Object[] -> String[]으로 Downcasting은 할 수 없음. 따라서 classCastException이 발생함.
        String[] attributes = pickTwo("좋은", "빠른", "저렴한"); // classCastException 발생.
        System.out.println(Arrays.toString(attributes));

        String[] strings = new String[10];
        Object[] obj = strings;
        obj[0] = 1;


    }

}
