package com.example.effectivejava1.chapter22.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5); // immutableCollection임

        // UnsupportedOperationException 발생
        // numbers.add(1);
        // numbers.remove(1);

        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);

        // 이터레이션으로 콜렉션을 순회하는 중에 Collection의 remove를 사용하면,
        // ConcurrentModificationException 발생
        for (Integer number : numberList) {
            if (number == 3) {
                numberList.remove(number);
            }
        }

        // 이터레이터의 remove 사용하기
        // Exception 발생 X
        for (Iterator<Integer> iterator = numberList.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            if (integer == 3) {
                iterator.remove();
            }
        }

        // 인덱스 사용하기
        // Exception 발생 X
        for (int i = 0; i < numberList.size(); i++) {
            if (numberList.get(i) == 3) {
                numberList.remove(numberList.get(i));
            }
        }

        // removeIf 사용하기
        // 내부적으로 Iterator를 직접 사용하는 것과 동일
        // Exception 발생 X
        numberList.removeIf(integer -> integer == 3);
    }
}
