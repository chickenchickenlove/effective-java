package com.example.effectivejava1.chapter33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public abstract class TypeRef<T> {

    private final Type type;

    protected TypeRef() {
        // 부모의 제네릭에 자식이 선언한 값을 넣는다. 그리고 그 정보가 넘은 것을 이용해 List<String>.class 같은 느낌을 구현함.
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = superClass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TypeRef && ((TypeRef) o).type.equals(type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public Type getType() {
        return type;
    }
}
