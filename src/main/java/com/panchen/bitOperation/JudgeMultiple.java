package com.panchen.bitOperation;

/**
 * @Description: 判断是否是16的倍数
 * @author: chenp
 * @date: 2020/02/25 15:21
 */
public class JudgeMultiple {

    public static void main(String[] args) {
        int i = 16;
        System.out.println((i & 15) == 0);
    }

}
