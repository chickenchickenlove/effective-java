package com.example.effectivejava1.chapter17;

// 코드 17-1 불변 복소수 클래스 (106-107쪽)
public class Complex {

    private final double re;
    private final double im;

    // 자주 사용하는 값은 상수로 만들어 둔다.
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {return re;}
    public double imaginaryPart() {return im;}

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    // 코드 17-2 정적 팩터리 (private 생성자와 함께 사용해야 한다.) (110-111쪽)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }


    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re - im*c.im, re * c.im + im * c.re);
    }

    // 다단계 연산자 제공
    public Complex doProcess(Complex c) {
        // 여기서 모든 연산을 한번에 처리한다.
        // 1. 모든 연산을 처리한 값을 계산한다.
        // 2. 계산한 값을 바탕으로 새로운 Complex 인스턴스를 생성해서 반환한다.
        // 3. 이 경우, 연산 결과로 생성되는 인스턴스는 오직 하나다.
        return null;
    }



    // 불변 클래스는 실패 원자성을 제공한다.
    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                (im * c.re - re * c.im) / tmp);
    }
}
