package com.panchen.myAlgorithm;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author pc
 *
 */
public class MaxMMin {

    public static void main(String[] args) {
        int[] in = {1, 3, 7, 4};
        System.out.println(getMaxMMin(in, 4));
    }

    static int getMaxMMin(int[] in, int n) {
        if (null == in || 0 >= in.length) {
            return 0;
        }
        LinkedList<Integer> maxDeque = new LinkedList<>();
        LinkedList<Integer> minDeque = new LinkedList<>();
        int res = 0;
        int j = 0;
        // 从in的头开始遍历
        for (int i = 0; i < in.length; i++) {
            // 挪动窗口
            for (; j < in.length; j++) {
                while (!minDeque.isEmpty() && in[minDeque.peek()] >= in[j]) {
                    minDeque.pollLast();
                }
                minDeque.add(j);
                while (!maxDeque.isEmpty() && in[maxDeque.peek()] <= in[j]) {
                    maxDeque.pollLast();
                }
                maxDeque.add(j);
                if (in[maxDeque.peekFirst()] - in[minDeque.peekFirst()] > n) {
                    break;
                }
            }
            if (i == minDeque.peekFirst()) {
                minDeque.pollFirst();
            }
            if (i == maxDeque.peekFirst()) {
                maxDeque.pollFirst();
            }
            res += j - i;
        }
        return res;

    }

}
