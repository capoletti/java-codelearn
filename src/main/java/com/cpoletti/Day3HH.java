package com.cpoletti;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class Day3HH {

    //Zig Zag Sequence
    public static void Exercise1() {

        Integer a[] = {1,3,5,8,2};

        int mid = a.length / 2;

        Arrays.sort(a);
        Integer p[] = Arrays.copyOfRange(a,0,mid);
        Integer s[] = Arrays.copyOfRange(a, mid, a.length );
        Arrays.sort(s, Collections.reverseOrder());
        System.out.print(Arrays.toString(p).replace("[","").replace("]","").replace(",",""));
        System.out.print(" ");
        System.out.print(Arrays.toString(s).replace("[","").replace("]","").replace(",",""));
    }

    //Tower Breakers
    public static void Exercise2() {
        int n=1;
        int m=4;

        int ret;

        if(m == 1) ret = 2;
        ret = n % 2 == 1 ? 1 : 2;

        System.out.println(ret);
    }

    //Caesar Cipher
    public static void Exercise3() {

        String s = "www.abc.xy";
        int k = 87;

        System.out.println(Arrays.toString("abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT).getBytes()));
        System.out.println(Arrays.toString("W".toUpperCase(Locale.ROOT).getBytes()));
        System.out.println("abcdefghijklmnopqrstuvwxyz".length());
        //System.out.println(Character.isUpperCase(s.charAt(0)));
        //System.out.println(Character.isUpperCase(s.charAt(7)));

        if (k > 26){
            k = k % 26;
        }

        for (int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            int b = (int)c;

            if (b >=97 && b <=122) {
                b = b + k;
                if (b > 122) {
                    b = b - 122 + 96;
                }
            }

            if (b >=65 && b <=90) {
                b = b + k;
                if (b > 90) {
                    b = b - 90 + 64;
                }
            }

            System.out.print((char)b);
        }
    }
}
