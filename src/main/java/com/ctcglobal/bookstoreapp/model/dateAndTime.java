package com.ctcglobal.bookstoreapp.model;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class dateAndTime {
    private DateTimeFormatter yyyyMmDd = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter hhMmSs = DateTimeFormatter.ofPattern("hh:mm:ss");



    private ZoneId location = ZoneOffset.systemDefault();
    private ZonedDateTime zdt = LocalDateTime.now().atZone(location);
    private ZoneOffset zone = zdt.getOffset();

    public String getDate() {
        LocalDate rawDate = LocalDate.now();
        String date = rawDate.format(yyyyMmDd);
        return date;
    }

    public String getTime() {
        LocalTime rawTime = LocalTime.now();
        String time = rawTime.format(hhMmSs);
        return time;
    }

    public ZoneOffset getZone() { return zone; }

    public ZoneId getLocation() {
        return location;
    }
}
