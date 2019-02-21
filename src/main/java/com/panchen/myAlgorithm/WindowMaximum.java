package com.panchen.myAlgorithm;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author panchen
 *
 */
public class WindowMaximum {

    static int[] getWindowMaximum(int[] arr, int w) {
        LinkedList<Integer> window = new LinkedList<>();
        int[] result = new int[arr.length + 1 - w];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (window.isEmpty()) {
                window.addLast(i);
                continue;
            }
            // 维持一个降序队列
            while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
                window.pollLast();
            }
            window.addLast(i);
            // 过了窗口的过期位进行淘汰
            if (window.peekFirst() == i - w) {
                window.pollFirst();
            }
            // 取当前窗口最大值
            if (i + 1 >= w) {
                result[index++] = arr[window.peekFirst()];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 11, 3, 7, 8, 2, 12, 16};
        int[] result = getWindowMaximum(arr, 3);
        for (int i : result) {
            System.out.println(i);
        }

    }

}
