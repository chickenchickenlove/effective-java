package com.example.effectivejava1.chapter33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {

    static class Super<T> {
        T value; // T는 어떻게 추론할 수 있을까?
    }

    static class Sub extends Super<String> {
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
        // 필드의 타입은 Object다.
        // 제네릭은 소거로 구현되어있다. String은 컴파일 시점에 모두 소거되고 Object로 바뀐다.
        // 그리고 사용하는 쪽에서 String으로 Object를 캐스팅하는 코드가 들어간다.
        System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

        // 이 경우 제네릭 타입이 String인 것을 알 수 있다.
        Type type = Sub.class.getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) type;
        System.out.println(ptype.getActualTypeArguments()[0]);

        // 굳이 제네릭을 사용하지 않고, 익명 클래스를 사용해도 된다.
        Type type1 = (new Super<String>() {}).getClass().getGenericSuperclass();
        ParameterizedType ptype1 = (ParameterizedType) type1;
        System.out.println(ptype1.getActualTypeArguments()[0]);
    }
}
