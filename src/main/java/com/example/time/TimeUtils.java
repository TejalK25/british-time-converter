package com.example.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TimeUtils {

    private static final Map<Integer, String> NUM_WORDS = new HashMap<>();

    static {

        NUM_WORDS.put(1, "one");
        NUM_WORDS.put(2, "two");
        NUM_WORDS.put(3, "three");
        NUM_WORDS.put(4, "four");
        NUM_WORDS.put(5, "five");
        NUM_WORDS.put(6, "six");
        NUM_WORDS.put(7, "seven");
        NUM_WORDS.put(8, "eight");
        NUM_WORDS.put(9, "nine");
        NUM_WORDS.put(10, "ten");
        NUM_WORDS.put(11, "eleven");
        NUM_WORDS.put(12, "twelve");
    }

    public static String toBritishSpokenForm(String timeInput) {
        LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        int displayHour = hour % 12 == 0 ? 12 : hour % 12;
        int nextHour = (displayHour % 12) + 1;

        if (minute == 0) return NUM_WORDS.get(displayHour) + " o'clock";
        if (minute == 15) return "quarter past " + NUM_WORDS.get(displayHour);
        if (minute == 30) return "half past " + NUM_WORDS.get(displayHour);
        if (minute == 45) return "quarter to " + NUM_WORDS.get(nextHour);
        if (minute < 30) return minutesToWords(minute) + " past " + NUM_WORDS.get(displayHour);
        else return minutesToWords(60 - minute) + " to " + NUM_WORDS.get(nextHour);
    }

    private static String minutesToWords(int minutes) {
        if (minutes <= 20 || minutes % 10 == 0) {
            return numberToWords(minutes);
        }
        return numberToWords(minutes - (minutes % 10)) + "-" + numberToWords(minutes % 10);
    }

    private static String numberToWords(int number) {
        switch (number) {
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "forty";
            case 50:
                return "fifty";
            default:
                return NUM_WORDS.get(number);
        }

    }
}
