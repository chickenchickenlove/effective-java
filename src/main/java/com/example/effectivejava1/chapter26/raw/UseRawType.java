package com.example.effectivejava1.chapter26.raw;

public class UseRawType <E>{

    private E e;

    public static void main(String[] args) {

        // 컴파일 에러 발생
        // System.out.println(UseRawType<Integer>.class);
        System.out.println(UseRawType.class);

        UseRawType<String> stringType = new UseRawType<>();
        // 컴파일 에러 발생
        // System.out.println(stringType instanceof UseRawType<String>);

    }


}
