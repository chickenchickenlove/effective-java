package com.example.effectivejava1.chapter7.cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class CacheKeyMain {

    public static void main(String[] args) {

        SoftReference<CacheKey> softReference = new SoftReference<>(new CacheKey(1));
        System.out.println();

        WeakReference<CacheKey> weakReference = new WeakReference<>(new CacheKey(1));
        System.out.println();

        PhantomReference<CacheKey> phantomReference = new PhantomReference<>(new CacheKey(1), new ReferenceQueue<>());
        System.out.println();


    }

}
