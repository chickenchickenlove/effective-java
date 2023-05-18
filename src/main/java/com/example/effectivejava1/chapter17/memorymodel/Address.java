package com.example.effectivejava1.chapter17.memorymodel;

public class Address {

    private String zipCode;
    private String city;
    private String area;


    public Address(String zipCode, String city, String area) {
        this.zipCode = zipCode;
        this.city = city;
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
