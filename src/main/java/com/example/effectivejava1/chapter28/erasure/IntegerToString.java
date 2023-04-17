package com.example.effectivejava1.chapter28.erasure;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {


    public static void main(String[] args) {
        // 공변
        // 배열은 공변이기 때문에 String[]이 상위 타입의 Object[]로 변할 수 있다.
        // 배열은 성능 관점(인덱스 바로 접근)에서는 좋지만, 공변이기 때문에 런타임 에러의 발생이 크다.
        Object[] anything = new String[10];
        anything[0] = 1; // Exception 발생

        // 불공변
        // List는 제네릭을 사용할 수 있다. 제네릭은 불공변이다.
        // List<String> / List<Integer>는 서로 다른 타입이기 때문에 위처럼 사용할 수는 없다.
        List<String> names = new ArrayList<>();
        // List<Object> objects = names; // 제네릭은 불공변이기 때문에 이렇게 동작할 수 없음.


        // 제네릭과 배열을 같이 사용할 수 있다면
        /*List<String>[] stringLists = new ArrayList<String>[1];
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;

        String s = stringLists[0].get(0);*/
    }




}
