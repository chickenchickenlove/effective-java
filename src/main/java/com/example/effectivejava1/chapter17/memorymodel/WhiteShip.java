package com.example.effectivejava1.chapter17.memorymodel;

public class WhiteShip {

    private int x, y;

    public WhiteShip() {
        this.x = 1;
        this.y = 2;
    }

    public static void main(String[] args) {
        // 두 가지 실행 방법이 존재 (그 이상 존재할 수도)
        // 1. Object w = new Whiteship()
        // 2. whiteShip = w
        // 3. w.x = 1
        // 4. w.y = 2

        // 1. Object w = new Whiteship()
        // 2. w.x = 1
        // 3. w.y = 2
        // 4. whiteShip = w
        WhiteShip whiteShip = new WhiteShip();
    }
}
