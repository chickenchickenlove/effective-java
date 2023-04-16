package com.example.effectivejava1.chapter27.annotation;

import java.lang.annotation.*;


// 이 어노테이션을 사용하는 클래스에서 Java Doc 생성 시
// 어노테이션 정보가 Java Doc에 포함됨.
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotation {
}
