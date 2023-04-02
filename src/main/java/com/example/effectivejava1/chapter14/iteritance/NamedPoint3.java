package com.example.effectivejava1.chapter14.iteritance;

import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;
import java.util.TreeSet;

@Getter
@ToString
public class NamedPoint3 extends Point {

    final private String name;


    public NamedPoint3(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }


    @Override
    public int compareTo(Point o) {
        int result = super.compareTo(o);
        if (result == 0) {
            NamedPoint3 o2 = (NamedPoint3) o;
            result = this.name.compareTo(o2.getName());
        }
        return result;
    }

    public static void main(String[] args) {
        NamedPoint3 p1 = new NamedPoint3(1, 0, "keesun");
        NamedPoint3 p2 = new NamedPoint3(1, 0, "whiteShip");

        System.out.println(p1.compareTo(p2));
    }

}
