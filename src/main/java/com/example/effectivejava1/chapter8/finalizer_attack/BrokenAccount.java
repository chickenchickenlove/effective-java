package com.example.effectivejava1.chapter8.finalizer_attack;

import java.math.BigDecimal;

public class BrokenAccount extends Account{

    public BrokenAccount(String accountId) {
        super(accountId);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(BigDecimal.valueOf(1000000), "hello");
    }
}
