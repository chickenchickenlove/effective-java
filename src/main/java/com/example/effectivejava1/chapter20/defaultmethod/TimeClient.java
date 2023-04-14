package com.example.effectivejava1.chapter20.defaultmethod;

import java.time.*;

// Item 20 : Default 메서드는 인터페이스의 유연한 확장에 도움된다.
public interface TimeClient {

    void setTime(int hour, int minute, int second);

    void setDate(int day, int month, int year);

    void setDateAndTime(int day, int month, int year,
                        int hour, int minute, int second);


    LocalDateTime getLocalDateTime();

    static ZoneId getZonedId(String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid Time Zone: " + zoneString);
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZonedId(zoneString));
    }
}
