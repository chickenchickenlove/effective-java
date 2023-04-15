package com.example.effectivejava1.chapter26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {

    public static void main(String[] args) {
        // Generic 사용하기 전
        List numbers = new ArrayList();
        numbers.add(10);
        numbers.add("whiteship");

        // 로 타입으로 사용 → 타입을 추론할 수 없음 → 수동 캐스팅 필요함.
        for (Object number : numbers) {
            System.out.println((Integer) number);
        }

        // Generic 등장 이후
        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
//        numberList.add("whiteship"); // 컴파일 에러 발생

        // 자동으로 타입 완성됨.
        for (Integer integer : numberList) {
            System.out.println(integer);
        }
    }
}
