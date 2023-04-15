package com.example.effectivejava1.chapter26.genericdao;

public class Account implements Entity{

    private Long id;

    @Override
    public Long getId() {
        return id;
    }
}
