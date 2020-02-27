package com.panchen.lambda;

/**
 * @Description:   custom  Lambda
 * @author: chenp
 * @date: 2020/02/27 11:15
 */
public class CustomLambdaTest {


    public static void printString(Test<String> test, String s) {
        test.test(s);
    }

    public static void main(String[] args) {
        printString(input -> System.out.println(input), "hello world");

    }
}

@FunctionalInterface
interface Test<T> {

    void test(T x);

}
