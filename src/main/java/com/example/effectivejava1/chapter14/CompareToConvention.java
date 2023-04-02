package com.example.effectivejava1.chapter14;

import java.math.BigDecimal;

public class CompareToConvention {

    public static void main(String[] args) {
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(53534552);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // p88, 반사성
        System.out.println(n1.compareTo(n1));

        // p88, 대칭성
        // n1이 n2보다 컷다면, n2를 가지고 n1을 가지고 비교하면 n2가 작다고 나와야함.
        // n2 < n1 --> n1 > n2 (이게 대칭성임)
        System.out.println(n1.compareTo(n2));
        System.out.println(n2.compareTo(n1));

        // p89, 추이성
        // n3 > n1, n1 > n2이면 n3 > n2 인 것을 만족하는 것임.
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        // p89, 일관성
        // 동일한 인스턴스를 여러번 비교해도 같은 결과가 나와야한다는 것이 일관성이긴 한데.
        // n4,n2가 같으니 n4,n1 비교 / n2,n1 비교가 같은 값이 나와야한다.
        System.out.println(n4.compareTo(n2));
        System.out.println(n4.compareTo(n1));
        System.out.println(n2.compareTo(n1));

        // p89, compareTo가 0이라면 equals는 true여야 한다. (아닐 수도 있고...)
        // 지켜주는 것이 좋다. 그런데 아래 같은 경우에는 아닐 수도 있다.
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.compareTo(oneZeroZero));
        System.out.println(oneZero.equals(oneZeroZero));
    }

}
