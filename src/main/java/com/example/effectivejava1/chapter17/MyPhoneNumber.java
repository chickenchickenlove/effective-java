package com.example.effectivejava1.chapter17;

public class MyPhoneNumber extends PhoneNumber{

    public MyPhoneNumber(short areaCode, short prefix, short lineNum) {
        super(areaCode, prefix, lineNum);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
