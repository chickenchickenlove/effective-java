package com.example.effectivejava1.chapter31.typeinference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {

    // 타입 U는 메서드에 전달된 값을 보고 추론한다.
    private static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    // 타입 U는 메서드에 전달된 값을 보고 추론한다.
    private static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    private static void processStringList(List<String> stringList) {

    }


    public static void main(String[] args) {
        // <> 연산자를 이용하면 컴파일러가 타입을 추론해서 생성한다.
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();

        // 메서드 매개변수로 충분히 제네릭 타입을 추론할 수 있다. 따라서 반환 타입은 생략해도 된다.
        BoxExample.<Integer>addBox(10, listOfIntegerBoxes);
        BoxExample.addBox(20, listOfIntegerBoxes);
        BoxExample.addBox(30, listOfIntegerBoxes);
        BoxExample.outputBoxes(listOfIntegerBoxes);

        // Target Type
        List<String> stringList = Collections.emptyList(); // 좌측 타입을 보고 추론
        List<Integer> integerList = Collections.emptyList(); // 좌측 타입을 보고 추론
        BoxExample.processStringList(Collections.emptyList()); // 매개변수가 <String>인 것을 보고 추론
    }



}
