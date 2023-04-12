package com.example.effectivejava1.chapter15.member;

import java.lang.reflect.Field;

// 세부 구현 사항. 패키지 내부에서만 사용.
class DefaultMemberServiceWithJustPrivate implements MemberService{

    private int n1;
    public DefaultMemberServiceWithJustPrivate() {
    }

    public void printData() {
        Field[] declaredFields = MemberRepositoryWithPrivate.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field Type = " + field.getType());
            System.out.println("field Name = " + field.getName());
        }
    }

    // 내부 중첩 클래스 + private static으로 사용
    private class MemberRepositoryWithPrivate{

    }
    public static void main(String[] args) {
        DefaultMemberServiceWithJustPrivate defaultMemberServiceWithJustPrivate = new DefaultMemberServiceWithJustPrivate();
        defaultMemberServiceWithJustPrivate.printData();
    }
}
