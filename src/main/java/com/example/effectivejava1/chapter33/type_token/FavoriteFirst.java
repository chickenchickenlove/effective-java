package com.example.effectivejava1.chapter33.type_token;

import java.util.List;

// 타입 안전 컨테이너
public class FavoriteFirst<T> {

    List<T> value;

    // 타입 안전하며, 하나의 타입만 넣을 수 있는 컨테이너
    public static void main(String[] args) {
        FavoriteFirst<String> names = new FavoriteFirst<>();
        names.value.add("whiteship"); // 문자열만 넣을 수 있음

        FavoriteFirst<Integer> numbers = new FavoriteFirst<>();
        numbers.value.add(1);
    }
}
