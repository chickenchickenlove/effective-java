package com.example.effectivejava1.chapter33.type_token;

import java.util.HashMap;
import java.util.Map;

// 타입 안전 이종 컨테이너
public class FavoriteThird {

    // Class<?>를 사용하는 것만으로는 타입을 보장하지 못한다. 대신, 어떠한 객체도 들어올 수 있다.
    private final Map<Class<?>, Object> map = new HashMap<>();

    // Class<?>의 타입 안정성을 메서드 수준에서 보장해준다.
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(clazz, value);
    }

    // 이렇게 하면 타입 안정성을 보장하지 못함.
    /*public <T> void put(Class clazz, Object value) {
        this.map.put(clazz, value);
    }*/

    // 꺼낸 객체가 T 타입으로 캐스팅 가능한지 검사를 하지 않아서 에러가 발생함.
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz) {
        return (T) this.map.get(clazz);
    }

    // 타입안전하지 않은 이종 컨테이너.
    public static void main(String[] args) {
        FavoriteThird favorites = new FavoriteThird();

        // favorites.put(String.class, 1); // 컴파일 에러 발생함.
        favorites.put(Integer.class, 1);
        favorites.put(String.class, "keesun");

        String s = favorites.get(String.class);

    }
}
