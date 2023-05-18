package com.example.effectivejava1.chapter17;

import com.example.effectivejava1.chapter17.memorymodel.Address;

import java.awt.geom.Area;

// 내부에 가변 변수가 있으면, 불변 클래스의 불변성은 깨질 수 있다.
// 내부에 가변 변수가 있으면, 외부에서 접근할 수 없어야 한다.
public final class Person {

    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public static void main(String[] args) {
        Person person = new Person(new Address("he","hello", "hi"));
        Address address1 = person.getAddress();
        address1.setCity("redMond");
    }
}
