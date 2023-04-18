package com.example.effectivejava1.chapter31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// T 생산자 매개변수에 와일드카드 타입 적용
public class Chooser<T> {
    private final List<T> choiceList;
    private final Random rnd = new Random();

    // 코드 31-5 T 생산자 매개변수에 와일드카드 타입 적용 (184쪽)
    public Chooser(Collection<? extends T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        return this.choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser<Number> chooser = new Chooser<>(intList); // 컴파일 에러 없애기 위해 한정적 와일드카드
        for (int i = 0; i < 10; i++) {
            Number choice = chooser.choose();
            System.out.println(choice);
        }
    }
}
