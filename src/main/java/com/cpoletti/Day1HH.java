package com.cpoletti;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day1HH {

    //Plus Minus
    public static void Exercise1() {

        List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);

        double size = arr.size();
        double zero = arr.stream().filter(e -> e == 0).count();
        double plus = arr.stream().filter(e -> e > 0).count();
        double minus = arr.stream().filter(e -> e < 0).count();

        System.out.println(String.format("%.6f", plus / size));
        System.out.println(String.format("%.6f", minus / size));
        System.out.println(String.format("%.6f", zero / size));

    }

    //Mini-Max Sum
    public static void Exercise2() {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());
        Long maximum = sortedList.stream().skip(1).map(e -> e.longValue()).reduce(Long.valueOf(0), Long::sum);
        Long minimum = sortedList.stream().limit(arr.size() - 1).map(e -> e.longValue()).reduce(Long.valueOf(0), Long::sum);

        System.out.println(String.format("%s %s", minimum, maximum));
    }

    //Time Conversion
    public static void Exercise3() {

        String s = "07:05:45PM AM";

        String period = s.substring(8, 10);
        String time = s.substring(0, 8);

        boolean isAM = period.equals("AM");
        boolean isPM = period.equals("PM");

        LocalTime date = LocalTime.parse(time);

        if ((isAM && date.getHour() == 12) || (isPM && date.getHour() != 12)) {
            date = date.plusHours(12);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(date.format(formatter));
    }
}
