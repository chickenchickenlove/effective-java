package com.example.effectivejava1.chapter19.implspec;

/**
 * Example class for java documentation for extendable class
 */

public class ExtendableClass {
    /**
     * This method can be overriden to print any message.
     *
     * @ImplSpec
     * Please use System.out.println().
     */
    public void doSomething() {
        System.out.println("hello");
    }
}
