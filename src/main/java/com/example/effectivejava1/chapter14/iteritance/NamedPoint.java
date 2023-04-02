package com.example.effectivejava1.chapter14.iteritance;

import lombok.Getter;

import java.util.Comparator;

@Getter
public class NamedPoint implements Comparable<NamedPoint> {

    final private Point point;
    final private String name;


    public NamedPoint(Point point, String name) {
        this.point = point;
        this.name = name;
    }


    @Override
    public int compareTo(NamedPoint o) {
        int result = point.compareTo(o.getPoint());
        if (result == 0) {
            result = name.compareTo(o.getName());
        }
        return result;
    }

    public static void main(String[] args) {
        NamedPoint3 p1 = new NamedPoint3(1, 0, "keesun");
        NamedPoint3 p2 = new NamedPoint3(1, 0, "whiteShip");

        System.out.println(p1.compareTo(p2));
    }

}
