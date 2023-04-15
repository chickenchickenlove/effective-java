package com.example.effectivejava1.chapter24.nonstaticmemberclass;

import java.util.AbstractSet;
import java.util.Iterator;

// ITEM24 - 정적 멤버 클래스 --> 어댑터 패턴에 유용함.
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        // MySet은 Iterator가 없다. --> 사용자는 Iterator 타입을 사용하고 싶어함.
        // Adapter 패턴을 이용해서 처리할 수 있음.
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    // 어댑터 역할
    // 클라이언트가 원하는 Iterator를 구현함 → Iterator 타입으로 호환 가능해짐.
    private class MyIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
