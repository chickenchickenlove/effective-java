package com.example.effectivejava1.chapter18.callback;

public class Service {

    public void run(FunctionToCall functionToCall) {
        System.out.println("뭐 좀 하다가...");
        // 콜백함수 호출
        functionToCall.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
        bobFunction.run();
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);
        bobFunctionWrapper.run();

    }
}
