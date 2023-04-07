package com.example.effectivejava1.chapter17;

public class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    /*public void doSomething() {
        // final로 상태변경 방지
        this.areaCode = 10;
    }*/

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNum() {
        return lineNum;
    }
}
