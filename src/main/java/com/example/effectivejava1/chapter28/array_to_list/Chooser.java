package com.example.effectivejava1.chapter28.array_to_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 List + Generic 사용
public class Chooser<E> {
    private final List<E> choiceList;

    public Chooser(Collection<E> choiceList) {
        // 방어적 복사
        this.choiceList = new ArrayList<>(choiceList);
    }

    public E choose() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        Chooser<Integer> chooser = new Chooser<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose(); // 컴파일 타임의 타입 안정성 확보
            System.out.println(choice);
        }
    }
}
