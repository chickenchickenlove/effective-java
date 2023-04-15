package com.example.effectivejava1.chapter20.multipleinheritance;

// 인터페이스인 Flyable을 구현하도록 함.
// Flyable의 구현체인 MyFlyable을 내부 클래스로 가지고, 이 클래스를 통해 fly를 deligate함.
public class MyCat extends AbstractCat implements Flyable{

    private MyFlyable myFlyable = new MyFlyable();

    @Override
    protected String sound() {
        return "인싸 고양이 두 마리가 나가신다!";
    }

    @Override
    protected String name() {
        return "유미";
    }

    public static void main(String[] args) {
        MyCat myCat = new MyCat();
        System.out.println(myCat.sound());
        System.out.println(myCat.name());
    }

    @Override
    public void fly() {
        this.myFlyable.fly();
    }

    private class MyFlyable extends AbstractFlyable {
        @Override
        public void fly() {
            System.out.println("날아라.");
        }
    }
}
