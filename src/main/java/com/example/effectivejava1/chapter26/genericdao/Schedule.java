package com.example.effectivejava1.chapter26.genericdao;

public class Schedule implements Entity{

    private Long id;

    public Schedule(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return null;
    }
}
