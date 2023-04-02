package com.example.effectivejava1.chapter14;

import lombok.Getter;

import java.util.Comparator;

@Getter
public class PhoneNumber implements Cloneable, Comparable<PhoneNumber>{

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    // 코드 14-2 기본 타입 필드가 여럿일 때의 비교자 (91쪽)
    @Override
    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, pn.lineNum);
            }
        }
        return result;
    }

    /*
    // 코드 14-3 비교자 생성 메서드를 활용한 비교자
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.getAreaCode())
                    .thenComparingInt(value -> value.getPrefix())
                    .thenComparingInt(value -> value.getLineNum());

    @Override
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }*/



    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
