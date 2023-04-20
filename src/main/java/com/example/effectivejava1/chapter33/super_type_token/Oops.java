package com.example.effectivejava1.chapter33.super_type_token;

import java.util.ArrayList;
import java.util.List;

public class Oops {

    static Favorites2 f = new Favorites2();

    static <T> List<T> favoriteList() {
        // 익명 자식 클래스로 선언
        TypeRef<List<T>> ref = new TypeRef<List<T>>() {};
        System.out.println(ref.getType().getTypeName()); // 항상 java.util.List<T>가 됨.

        List<T> result = f.get(ref); // List<T>로 해시코드가 같음.
        if (result == null) {
            result = new ArrayList<T>();
            f.put(ref, result);
        }
        return result;
    }

    public static void main(String[] args) {
        // List<T>로 ls, li의 해시코드가 동일함. 따라서 ls, li는 동일한 객체를 반환받아서 공유한다.
        List<String> ls = favoriteList();
        List<Integer> li = favoriteList();
        li.add(1);

        for (String s : ls) {
            System.out.println(s); // 캐스팅 에러 발생함.
        }
    }
}
