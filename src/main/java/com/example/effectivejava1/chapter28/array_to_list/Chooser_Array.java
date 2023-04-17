package com.example.effectivejava1.chapter28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 배열 기반 Chooser
public class Chooser_Array {
    private final Object[] choiceList; // 형변환 문제의 해결책은 Integer[]로 사용하는 것이다.

    public Chooser_Array(Collection choiceList) {
        this.choiceList = choiceList.toArray();
    }

    public Object choose() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return choiceList[rnd.nextInt(choiceList.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser_Array chooser = new Chooser_Array(intList);

        List<String> stringLIst = List.of("a");
        Chooser_Array chooser1 = new Chooser_Array(stringLIst);

        for (int i = 0; i < 10; i++) {
            Number choice = (Number) chooser.choose(); // choose가 제공하는 값은 항상 (Number) 타입이 아닐 수 있다.
            System.out.println(choice);
        }
    }
}
