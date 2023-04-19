package com.example.effectivejava1.chapter32.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExampleUnSafe implements Runnable{

    // not thread-safe.
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmm");

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExampleUnSafe obj = new ThreadLocalExampleUnSafe();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name = " + Thread.currentThread().getName() + " default Formatter = " + formatter.toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // not thread-safe
        formatter = new SimpleDateFormat();
        System.out.println("Thread Name = " + Thread.currentThread().getName() + " Formatter = " + formatter.toPattern());
    }
}
