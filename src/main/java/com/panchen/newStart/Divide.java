package com.panchen.newStart;

/**
 * @Description:
 *
 *  leetcode 29 两数相除
 *
 *  给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  看到这题有点摸瞎，，，
 *
 *  看了题解总结下 ， 又一次踩在巨人肩膀上 ， 举例100/10 翻倍3次10以后到80 发现再翻倍就不行了 拿100-80=20 再去20/10 递归
 *
 *  内核 就是 K = b0 * 2^0 + b1 * 2^1 + b2 * 2^2 + ... + bn * 2^n + ...  任何一个数都符合
 * @author: chenp
 * @date: 2020/06/17 19:11
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(div(100,10));
    }


    public static  long div(long a, long b) {


        if(a < b) return 0;

        int i = 0;
        while( a >= (b<<i) ){
            i++;
        }
        i--;

        return (1<<i) + div(a - (b<<i) , b);
    }



}
