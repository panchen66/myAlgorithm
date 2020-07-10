package com.panchen.classicalAlgorithm;

import java.util.Arrays;

/**
 * @Description: 冒泡排序就是 相互的2个位置 比 大小  大的挪到最后  下一轮在从0到n-已经排除的顺序的位置数量 也是o(n^2)
 * @author: chenp
 * @date: 2020/07/10 16:20
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 33, 15, 28, 6, 7, 1414};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }

        }
        return a;
    }

    private static void swap(int[] data, int source, int to) {
        int tmp = data[to];
        data[to] = data[source];
        data[source] = tmp;
    }


}
