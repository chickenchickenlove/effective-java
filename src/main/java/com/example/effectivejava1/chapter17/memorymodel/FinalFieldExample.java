package com.example.effectivejava1.chapter17.memorymodel;

public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        this.x = 3;
        this.y = 4;
    }

    static void write() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x; // 3을 보는 것을 보장
            int j = f.y; // 0을 볼 수도 있음.
        }
    }
}

