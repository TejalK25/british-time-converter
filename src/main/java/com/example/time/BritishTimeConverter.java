package com.example.time;

public class BritishTimeConverter {

    public static void main(String[] args) {
        // Demo runner
        String[] testInputs = {"01:00", "02:05", "03:10", "04:15", "07:30", "09:45", "00:00", "12:00", "18:32"};

        for (String input : testInputs) {
            System.out.printf("%s -> %s%n", input, TimeUtils.toBritishSpokenForm(input));
        }
    }
}
