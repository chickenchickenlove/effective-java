package com.example.effectivejava1.chapter26.terms;

// Box<E>에서 E는 타입 매개변수.
public class Box<E> {

    private E item;

    private void add(E e) {
        this.item = e;
    }

    private E get() {
        return this.item;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>();
        box.add(10);
        System.out.println(box.get() * 100);

        printBox(box);
    }

    public static void main2(String[] args) {
        Box<String> box = new Box<>();
        box.add("hello");
    }


    // 비한정적 와일드카드 타입
    private static void printBox(Box<?> box) {
        System.out.println(box.get());

    }
}
