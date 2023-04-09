package com.example.effectivejava1.chapter18.callback;

public class BobFunction implements FunctionToCall{

    private final Service service;

    public BobFunction(Service service) {
        this.service = service;
    }

    @Override
    public void call() {
        System.out.println("밥을 먹을까..");
    }

    @Override
    public void run() {
        // 자기 일 끝나고, callback 함수를 준다.
        this.service.run(this);
    }
}
