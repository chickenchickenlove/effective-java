package com.example.effectivejava1.chapter31;

import com.example.effectivejava1.chapter31.example.IntegerBox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

// 재귀적 타입 한정을 이용해 상호 비교할 수 있음을 표현 (179쪽)
public class RecursiveTypeBound {
    // 코드 30-7 컬렉션에서 최대값을 반환한다. - 재귀적 타입 한정 사용 (179쪽)
    //public static <E extends Comparable<? E>> E max(List<? extends E> c) { // 이렇게 사용하면 컴파일 에러
    public static <E extends Comparable<? super E>> E max(List<? extends E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0) // 값을 꺼내서 비교한다. 따라서 Consumer임.
                result = Objects.requireNonNull(e);

        return result;
    }

    public static void main(String[] args) {
        List<String> argList = List.of("keesun", "whiteship");
        System.out.println(max(argList));
    }

    public static void hello() {
        List<IntegerBox> list = new ArrayList<>();
        list.add(new IntegerBox(1, "keesun"));
        list.add(new IntegerBox(2, "whiteship"));

        IntegerBox max = max(list); // 컴파일 에러 발생 -> 확장자 와일드카드 사용하지 않으면.


        System.out.println(max(list));
    }
}
