package com.cpoletti;

import java.util.*;
import java.util.stream.Collectors;

public class Day2HH {

    //Lonely Integer
    public static void Exercise1() {

        List<Integer> a = Arrays.asList(1, 1, 3, 4, 4);
        Map<Integer, Integer> listTotal = new HashMap<>();
        Map<Integer, Integer> listChecked = new HashMap<>();

        a.forEach((e) -> {

            if (listTotal.containsValue(e))
                listChecked.remove(e);
            else
                listChecked.put(e, e);

            listTotal.put(e, e);
        });

        System.out.println(Integer.valueOf(listChecked.values().toArray()[0].toString()).intValue());
    }

    //Diagonal Difference
    public static void Exercise2() {

        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12));

        int iD = 0;
        int iE = arr.size() - 1;

        int countD = 0;
        int countE = 0;
        //var list = arr.stream().skip(1).collect(Collectors.toList());

        for (List<Integer> listItem : arr) {
            System.out.println(listItem);

            countD += listItem.get(iD);
            countE += listItem.get(iE);

            iD++;
            iE--;
        }

        System.out.println(Math.abs(countD - countE));
    }

    //Counting Sort 1
    public static void Exercise3() {

        List<Integer> arr = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33);

        int[] count = new int[100];
        //int[] count = new int[arr.size()];

        for (int i : arr) {
            count[i]++;
        }

        List<Integer> list = Arrays.stream(count).boxed().collect(Collectors.toList());

        System.out.println(list);
    }


    public static void runFlippingMatrix(){

        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)

        );
        flippingMatrix(matrix);
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int size = matrix.size();
        for (int r = 0; r < size / 2; r++) {
            for (int c = 0; c < size / 2; c++) {

                int num1 = matrix.get(r).get(c);
                int num2 = matrix.get(r).get(size - 1 - c);
                int num3 = matrix.get(size - 1 - r).get(c);
                int num4 = matrix.get(size - 1 - r).get(size - 1 - c);

                sum += Math.max(num1, Math.max(num2, Math.max(num3, num4)));
            }
        }
        return sum;
    }
}