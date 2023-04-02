package com.example.effectivejava1.chapter14.iteritance;

import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;
import java.util.TreeSet;

@Getter
@ToString
public class NamedPoint2 extends Point {

    final private String name;


    public NamedPoint2(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    public static void main(String[] args) {
        NamedPoint2 p1 = new NamedPoint2(1, 0, "keesun");
        NamedPoint2 p2 = new NamedPoint2(1, 0, "whiteShip");

        // 정렬하기 위해서 Treeset 이용
        TreeSet<NamedPoint2> points = new TreeSet<>(new Comparator<NamedPoint2>() {
            @Override
            public int compare(NamedPoint2 o1, NamedPoint2 o2) {
                int result = Integer.compare(o1.getX(), o2.getX());
                if (result == 0) {
                    result = Integer.compare(o1.getY(), o2.getY());
                }

                if (result == 0) {
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });

        points.add(p1);
        points.add(p2);

        System.out.println("points = " + points);
    }

}
