package com.ctcglobal.shippingapp.model;

        import java.time.*;
        import java.time.format.DateTimeFormatter;
        import java.time.temporal.ChronoUnit;

public class dateAndTime {

    public dateAndTime() {}

    private DateTimeFormatter yyyyMmDd = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter hhMmSs = DateTimeFormatter.ofPattern("hh:mm:ss");



    private ZoneId location = ZoneOffset.systemDefault();
    private ZonedDateTime zdt = LocalDateTime.now().atZone(location);
    private ZoneOffset zone = zdt.getOffset();

/*    public String getDate() {
        LocalDate rawDate = LocalDate.now();
        String date = rawDate.format(yyyyMmDd);
        return date;
    }

    public String getTime() {
        LocalTime rawTime = LocalTime.now();
        String time = rawTime.format(hhMmSs);
        return time;
    }*/

    public String getDateTime() {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime rawDateAndTime = LocalDateTime.now();
        //String DateAndTime = rawDateAndTime.format(formatter);
        return rawDateAndTime.toString();
    }

    public ZoneOffset getZone() { return zone; }

    public ZoneId getLocation() {
        return location;
    }

    public long diffMinutesTime(String oldTime)
    {   LocalDateTime rawTime = LocalDateTime.now();
        LocalDateTime oldt = LocalDateTime.parse(oldTime);
        /*long minutes = ChronoUnit.MINUTES.between(oldt, rawTime);*/
        Duration duration = Duration.between(oldt, rawTime);
        long sec = duration.getSeconds();
        long minutes = sec / 60;
        System.out.println(duration.getSeconds() + " seconds or " + minutes + " minutes");
        return sec;
    }
}
