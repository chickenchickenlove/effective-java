package com.example.effectivejava1.chapter31;

import com.example.effectivejava1.chapter31.example.Box;
import com.example.effectivejava1.chapter31.example.IntegerBox;

import java.util.Arrays;
import java.util.List;

// 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드 (189쪽)
public class Swap {


    // 와일드카드를 쓰면 어차피 동일한 헬퍼 메서드를 빼야한다.
    public static <E> void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
        //list.set(i, list.set(j, list.get(i)));
    }

    // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

//    public static <E> void swap(List<E> list, int i, int j) {
//         list.set(i, list.set(j, list.get(i)));
//    }


    public static void main(String[] args) {
        // 첫번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
        List<String> argList = Arrays.asList(args);
        swap(argList, 0, argList.size() - 1);
        System.out.println(argList);


        Box<Integer> myBox = new IntegerBox(10, "keesun");
        myBox.change(100);

        Box<?> myBox2 = new IntegerBox(100, "kesun");
        // myBox2.change(100);
    }



}
