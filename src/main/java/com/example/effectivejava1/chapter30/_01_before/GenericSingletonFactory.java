package com.example.effectivejava1.chapter30._01_before;

import java.util.function.Function;

// 제네릭 싱글턴 팩토리 패턴 (178쪽)
public class GenericSingletonFactory {

    public static <E> Function<E, E> stringIdentityFunction1() {
        return (t) -> t;
    }

    public static Function<String, String> stringIdentityFunction() {
        return (t) -> t;
    }

    public static Function<Number, Number> integerIdentityFunction() {
        return (t) -> t;
    }

    // 코드 30-5 제네릭 싱글턴을 사용하는 예 (178쪽)
    public static void main(String[] args) {
        String[] strings = {"삼베", "대마", "나일론"};
        Function<String, String> sameString = stringIdentityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }

        Number[] numbers = {1, 2.0, 3L};
        Function<Number, Number> sameNumber = integerIdentityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }
}
