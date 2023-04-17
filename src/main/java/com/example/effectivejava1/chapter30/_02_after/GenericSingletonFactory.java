package com.example.effectivejava1.chapter30._02_after;

import java.util.function.Function;
import java.util.function.UnaryOperator;

// 제네릭 싱글턴 팩토리 패턴 (178쪽)
public class GenericSingletonFactory {

    // 코드 30-4 제네릭 싱글턴 팩터리 패턴 (178쪽)
    public static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // 코드 30-5 제네릭 싱글턴을 사용하는 예 (178쪽)
    public static void main(String[] args) {
        String[] strings = {"삼베", "대마", "나일론"};
        Function<String, String> sameString = identityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }

        Number[] numbers = {1, 2.0, 3L};
        Function<Number, Number> sameNumber = identityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }
}
