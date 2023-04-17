package com.example.effectivejava1.chapter29.technique1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

// Object를 이용한 제네릭 스택 (170-174쪽)
// 테크닉 1 : Object[] 생성 후, E[]로 형변환
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;


    /**
     * 1. 배열은 private로 선언됨. 다른 곳에서 접근할 수 없음.
     * 2. 배열에 직접 접근할 수 있는 포인트가 없음.
     * 3. 들어오는 값은 항상 E임. 따라서 무시 가능함.
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        /*Object[] e = this.elements;
        e[0] = "hello"; // Heap 오염 발생*/
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        E result = elements[--size];
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
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (Integer arg : List.of(1, 2, 3))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(((String)stack.pop()).toUpperCase());
    }
}