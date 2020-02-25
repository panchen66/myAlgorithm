package com.panchen.bitOperation;

/**
 * @Description: 求16的最小倍化
 * @author: chenp
 * @date: 2020/02/25 15:18
 */
public class Ploidy {

    public static void main(String[] args) {
        int i = 17;
        System.out.println((i & ~15) + 16);
    }

}
