package com.example.effectivejava1.chapter7.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        WeakReference<Object> weak = new WeakReference<>(strong);
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        // 거의 없어짐. 왜냐하면 Strong이 없어지면 바로 gc 대상이 되기 때문임.
        System.out.println(weak.get());
    }

}
