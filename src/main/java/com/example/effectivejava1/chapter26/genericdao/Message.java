package com.example.effectivejava1.chapter26.genericdao;

public class Message implements Entity{

    private Long id;

    public Message(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
