package com.panchen.classicalAlgorithm;

import java.util.Arrays;

/**
 * @Description:  选择排序就是每次选出最小的元素 排到前面来 循环往复 复杂度  n + n-1 + n-2 + … + 2 + 1 = n * (n+1) / 2 = 0.5 * n ^ 2 + 0.5 * n，那么时间复杂度是O(N^2)
 * @author: chenp
 * @date: 2020/07/10 11:49
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 33, 15, 28, 6, 7, 1414};
        System.out.println(Arrays.toString(selectSort(a)));
    }

    public static int[] selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, j, i);
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
