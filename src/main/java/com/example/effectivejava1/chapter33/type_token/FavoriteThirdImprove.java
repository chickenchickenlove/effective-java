package com.example.effectivejava1.chapter33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 타입 안전 이종 컨테이너
public class FavoriteThirdImprove {

    // Class<?>를 사용하는 것만으로는 타입을 보장하지 못한다. 대신, 어떠한 객체도 들어올 수 있다.
    private final Map<Class<?>, Object> map = new HashMap<>();

    // Class RawType으로 캐스팅되서 전달되는 경우, 타입 안정성 깨짐
    // 컴파일 에러 발생하지 않는데, 컴파일 에러로 바꿀 수 있는 방법이 없음.
    // 런타임에서 Fast-fail로 바꾸는 방법만 존재함.
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(clazz, clazz.cast(value));
        // this.map.put(clazz, value);
    }

    // 이렇게 하면 타입 안정성을 보장하지 못함.
    /*public <T> void put(Class clazz, Object value) {
        this.map.put(clazz, value);
    }*/


    public <T> T get(Class<T> clazz) {
        // 형변환 검사 후 리턴해서 경고를 없애준다.
        return clazz.cast(this.map.get(clazz));
    }

    // 타입안전하지 않은 이종 컨테이너.
    public static void main(String[] args) {
        FavoriteThirdImprove favorites = new FavoriteThirdImprove();

        // favorites.put(String.class, 1); // 컴파일 에러 발생함.
        favorites.put(Integer.class, 1);
        favorites.put(String.class, "keesun");

        // Class의 Raw 타입으로 캐스팅해서 전달하면 깨진다.
        // 컴파일 에러가 발생해야하는데, 발생하지 않음.
        // 런타임 에러가 발생하고, 컴파일 에러로 잡을 수 있는 방법은 없음.
        favorites.put((Class) String.class, 1);

        String s = favorites.get(String.class);

        // List<String>.class 같은 클래스 리터럴은 제공하지 않음.
        /*favorites.put(List<String>.class,
                List.of("a,b,c"));*/

    }
}
