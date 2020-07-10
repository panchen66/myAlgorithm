package com.panchen.classicalAlgorithm;

import java.util.Arrays;

/**
 * @Description:  插入排序就是从第二位开始 跟前面的i-1位比大小 保持i-1位的有序 弄到i就全有序了 时间复杂度跟选择排序一致
 * @author: chenp
 * @date: 2020/07/10 15:16
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] a = {1, 2, 33, 15, 28, 6, 7, 1414};
        System.out.println(Arrays.toString(insertSort(a)));
    }

    public static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                j--;
            }
            for (int z = i; z > j + 1; z--) {
                a[z] = a[z - 1];
            }
            a[j + 1] = tmp;

        }
        return a;
    }



}
