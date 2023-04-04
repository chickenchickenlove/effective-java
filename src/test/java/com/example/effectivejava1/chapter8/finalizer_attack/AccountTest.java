package com.example.effectivejava1.chapter8.finalizer_attack;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void 일반_계정() {
        Account account = new Account("keesun");
        account.transfer(BigDecimal.valueOf(10.4), "hello");
    }

    @Test
    void 푸틴_계정() {
        Account account = new Account("푸틴");
        account.transfer(BigDecimal.valueOf(10.4), "hello");
    }

    @Test
    void 푸틴_계정_finalizer_공격() throws InterruptedException {
        Account account;
        try {
            account = new BrokenAccount("푸틴");
            account.transfer(BigDecimal.valueOf(10.4), "hello");
        } catch (IllegalArgumentException e) {
            System.out.println("here");
        }
        System.gc();
        Thread.sleep(3000);

    }

}