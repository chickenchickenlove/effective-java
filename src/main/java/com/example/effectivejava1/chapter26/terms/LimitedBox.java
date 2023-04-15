package com.example.effectivejava1.chapter26.terms;

// 한정적 타입 매개변수. Number 하위 클래스만 E에 대입될 수 있음.
public class LimitedBox <E extends Number>{

    private E item;

    private void add(E e) {
        this.item = e;
    }

    private E get() {
        return this.item;
    }

    public static void main(String[] args) {
        LimitedBox<Integer> box = new LimitedBox<>();
        box.add(10);
    }

    // 한정적 와일드카드 타입
    private static void printBox(LimitedBox<? extends Number> box) {
        System.out.println(box.get());
    }
}
