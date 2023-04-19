package com.example.effectivejava1.chapter32;

import java.util.List;

// 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. (192 - 192쪽)
// 제네릭 + 가변인수 위험한 케이스. --> Heap Polution 발생하기 때문.
public class Dangerous {
    // 코드 32-1 제네릭과 varargs를 혼용하면 타입 안정성이 깨진다! (192 - 192쪽)
    static void dangerous(List<String>... stringLists) {
        List<String>[] stringLists1 = stringLists; // 배열과 제네릭을 함께 쓴 녀석이 나온다.

        List<Integer> intList = List.of(42);
        Object[] objects = stringLists; // List[] 타입의 배열이 된다. List의 상위는 Object이기 때문에 이렇게 동작한다.
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
