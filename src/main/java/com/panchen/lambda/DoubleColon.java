package com.panchen.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * jdk8 ::
 * 
 * @author pc
 *
 */
public class DoubleColon {

    public static String printValur(String str) {
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(DoubleColon::printValur);

        Function<String, String> f = DoubleColon::printValur;
        al.forEach(x -> f.apply("1"));
    }
}
