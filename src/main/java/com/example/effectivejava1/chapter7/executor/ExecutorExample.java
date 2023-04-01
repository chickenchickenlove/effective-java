package com.example.effectivejava1.chapter7.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        int numOfCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numOfCpu);
        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }

        System.out.println(Thread.currentThread() + " hello");
        service.shutdown();
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
