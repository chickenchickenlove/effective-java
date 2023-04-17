package com.example.effectivejava1.chapter28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {

    public static void main(String[] args) {
        // 제네릭으로 작성한 코드
        ArrayList<String> names = new ArrayList<>();
        names.add("keesun");
        String name = names.get(0);
        System.out.println(name);

        // 제네릭을 반영한 바이트 코드는 다음과 같이 작성된다.
        List names2 = new ArrayList();
        names2.add("keesun");
        Object o = names2.get(0);
        String name2 = (String) o; // 컴파일러가 작성해주는 코드
    }


}
