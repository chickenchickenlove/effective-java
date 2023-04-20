package com.example.effectivejava1.chapter33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 이종 컨테이너. 타입 안전하지 않음.
public class FavoriteSecond {

    private Map<Class, Object> map = new HashMap<>();

    // class가 예약어라 clazz를 사용한다.
    public void put(Class clazz, Object value) {
        this.map.put(clazz, value);
    }

    public Object pop(Class clazz) {
        return this.map.get(clazz);
    }

    // 타입안전하지 않은 이종 컨테이너.
    public static void main(String[] args) {
        FavoriteSecond favorites = new FavoriteSecond();
        favorites.put(String.class, 1); // 컴파일 에러 발생하지 않음. 타입 안전하지 않음.
        favorites.put(Integer.class, "keesun"); // 컴파일 에러 발생하지 않음. 타입 안전하지 않음.
        favorites.put(String.class, 1); // 컴파일 에러 발생하지 않음. 타입 안전하지 않음.

    }
}
