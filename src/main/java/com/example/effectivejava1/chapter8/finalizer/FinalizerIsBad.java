package com.example.effectivejava1.chapter8.finalizer;

public class FinalizerIsBad {

    @Override
    protected void finalize() throws Throwable {
        throw new Exception();
    }
}
