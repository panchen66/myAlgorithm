package com.panchen.bitOperation;

/**
 * a
 *
 * @Description: 来源netty  趋近2^n的最小值
 * @author: chenp
 * @date: 2020/02/25 14:19
 */
public class ApproachEvaluation {

    public static void main(String[] args) {
        int normalizedCapacity = 1025;
        normalizedCapacity--;
        normalizedCapacity |= normalizedCapacity >>> 1;
        normalizedCapacity |= normalizedCapacity >>> 2;
        normalizedCapacity |= normalizedCapacity >>> 4;
        normalizedCapacity |= normalizedCapacity >>> 8;
        normalizedCapacity |= normalizedCapacity >>> 16;
        normalizedCapacity++;

        if (normalizedCapacity < 0) {
            normalizedCapacity >>>= 1;
        }

        System.out.println(normalizedCapacity);
    }

}
