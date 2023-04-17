package com.example.effectivejava1.chapter28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 배열 기반 Chooser + Generic 사용
public class Chooser_Array_Generic<E> {
    private final E[] choiceList;

    @SuppressWarnings("unchecked")
    public Chooser_Array_Generic(Collection<E> choiceList) {
        this.choiceList = (E[]) choiceList.toArray();
    }

    public E choose() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        return choiceList[rnd.nextInt(choiceList.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        Chooser_Array_Generic<Integer> chooser = new Chooser_Array_Generic<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
