package com.example.effectivejava1.chapter10;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;

// URL은 도메인이 아닌, 도메인이 가진 IP로 equals를 확인한다.
// 따라서 일관성 위배 될 수 있음.
public class EqualsInJava extends Object {

    public static void main(String[] args) throws MalformedURLException {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(time);

        // 대칭성 위배! P60
        System.out.println(date.equals(timestamp));
        System.out.println(timestamp.equals(date));

        // 일관성 위배 가능성 있음. P61
        URL google1 = new URL("https", "about.google", "/products/");
        URL google2 = new URL("https", "about.google", "/products/");
        System.out.println(google1.equals(google2));
    }
}