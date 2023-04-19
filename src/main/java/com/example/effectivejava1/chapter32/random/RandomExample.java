package com.example.effectivejava1.chapter32.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExample {

    public static void main(String[] args) {
        // Random random = new Random();
        // System.out.println(random.nextInt(10)); // 성능 이슈가 있을 수 있음.

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt()); // 멀티 쓰레드 환경에서 thread safe 하기 때문에 실패하지 않음.
    }

    private int value;


    // Synchronized 키워드는 비관적 락이다.
    // 아래는 멀티 쓰레드 환경에서 Atomic이 대충 이런 식으로 돌아간다는 느낌으로 보면 된다.
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int readValue = value;
        if (readValue == expectedValue)
            value = newValue;
        return readValue;
    }
}
