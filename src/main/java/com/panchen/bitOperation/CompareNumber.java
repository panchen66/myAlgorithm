package com.panchen.bitOperation;

/**
 * @Description: 来源netty 判断是否小于512
 * @author: chenp
 * @date: 2020/02/25 14:49
 */
public class CompareNumber {

    public static void main(String[] args) {
        int i = 0;
        System.out.println((i & 0xFFFFFE00) == 0);

        System.out.println((i&-1)==0);
    }

}
