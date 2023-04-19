package com.example.effectivejava1.chapter31.example;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    protected T value;

    public Box(T value) {
        this.value = value;
    }

    public void change(T value) {
        this.value = value;
    }


    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Box anotherBox) {
        // Comparable value1 = anotherBox.value; // 다른 Box 매개변수는 무슨 타입 T인지 모른다.
        return this.value.compareTo((T) anotherBox.value);
    }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }
}
