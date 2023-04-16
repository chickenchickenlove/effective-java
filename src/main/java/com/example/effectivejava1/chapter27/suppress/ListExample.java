package com.example.effectivejava1.chapter27.suppress;

import java.util.Arrays;

public class ListExample {

    private int size;

    Object[] elements;

    // Uncheck 경고 제거 불가능하면,
    public <T> T[] toArray(T[] a) {
        if (a.length < size){
            /*
            왜 발생했는지 이유 작성
             */
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public static void main(String[] args) {

    }
}
