package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeServiceTest {

    private DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void shouldDaysBetweenBeZero() {
        Date date1 = createDate("01.01.2023");
        Date date2 = createDate("01.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 0L);
    }

    @Test
    public void shouldDaysBetweenBePositive() {
        Date date1 = createDate("01.01.2023");
        Date date2 = createDate("10.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, 9L);
    }

    @Test
    public void shouldDaysBetweenBeNegative() {
        Date date1 = createDate("10.01.2023");
        Date date2 = createDate("01.01.2023");
        var daysBetween = dateTimeService.getDaysBetween(date1, date2);
        assertEquals(daysBetween, -9L);
    }

    private Date createDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}