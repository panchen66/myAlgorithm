package com.panchen.lambda;

import java.util.function.Consumer;

/**
 * @Description: java.util.function : Consumer
 * @author: chenp
 * @date: 2020/02/27 11:01
 */
public class ConsumerTest {


    public static void test(Consumer consumer, String input) {
        consumer.accept(input);
    }

    public static void main(String[] args) {
        Consumer consumer = input -> System.out.println(input);
        test(consumer.andThen(input -> System.out.println("consumer")), "hello");
    }

}
