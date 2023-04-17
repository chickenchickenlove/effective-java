package com.example.effectivejava1.chapter29.technique2;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

// Object[] 그대로 사용 + 메서드쪽에서만 제네릭 사용한 Stack (Heap Polution 발생 X)
public class Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;


    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        /**
         * push로만 값이 들어옴.
         * push는 항상 E 타입임.
         */
        @SuppressWarnings("unchecked") E result = (E) elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 코드 29-5 제네릭 Stack을 사용하는 맛보기 프로그램 (174쪽)
    // 제네릭을 사용하기 전 클라이언트 코드
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (Integer arg : List.of(1, 2, 3))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(((String)stack.pop()).toUpperCase());
    }

    // 제네릭 사용 전 클라이언트 코드. 모두 Raw 타입
    public static void mainWithNoGeneric(String[] args) {
        Stack stack = new Stack();
        for (String arg : List.of("a", "b", "c"))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(((String)stack.pop()).toUpperCase());
    }

    // 제네릭 사용 후 클라이언트 코드.
    public static void mainWithGeneric(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : List.of("a", "b", "c"))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}