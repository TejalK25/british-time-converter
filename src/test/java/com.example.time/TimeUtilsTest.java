package com.example.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TimeUtilsTest {

    @Test
    public void testMidNight(){
        assertEquals("midnight", TimeUtils.toBritishSpokenForm("00:00"));
    }

    @Test
    public void testQuarterPast() {
        assertEquals("quarter past four", TimeUtils.toBritishSpokenForm("04:15"));
    }

    @Test
    public void testQuarterTo() {
        assertEquals("quarter to ten", TimeUtils.toBritishSpokenForm("09:45"));
    }

    @Test
    public void testHalfPast() {
        assertEquals("half past seven", TimeUtils.toBritishSpokenForm("07:30"));
    }

    @Test
    public void testMinutesPast() {
        assertEquals("five past two", TimeUtils.toBritishSpokenForm("02:05"));
    }

    @Test
    public void testMinutesTo() {
        assertEquals("ten to eleven", TimeUtils.toBritishSpokenForm("10:50"));
    }
}
