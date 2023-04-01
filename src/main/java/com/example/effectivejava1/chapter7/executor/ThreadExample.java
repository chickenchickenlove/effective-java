package com.example.effectivejava1.chapter7.executor;

public class ThreadExample {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }

        System.out.println(Thread.currentThread() + " hello");
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + " world");
        }
    }
}
