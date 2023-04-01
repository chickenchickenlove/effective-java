package com.example.effectivejava1.chapter7.executor;

import java.util.concurrent.*;

public class ExecutorWithCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numOfCpu = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(numOfCpu);

        // Non-Blocking
        Future<String> submit = service.submit(new Task());
        System.out.println(Thread.currentThread() + " hello");

        // Blocking
        System.out.println("submit.get().toString() = " + submit.get().toString());
        service.shutdown();
    }

    static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + " world");
            return Thread.currentThread().getName();
        }
    }
}
