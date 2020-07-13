package com.panchen.classicalAlgorithm;

import java.util.Arrays;

/**
 * @Description: 希尔排序
 * <p>
 * 即先保障间隔n位的元素有序 然后逐步减小这个n值
 * @author: chenp
 * @date: 2020/07/10 16:28
 */
public class ShellSort {

    public static void main(String[] args) {
        System.out
            .println(
                Arrays.toString(shellSort(new int[]{1, 3213, 22, 11, 321321, 199, 232131321})));


    }


    public static int[] shellSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 h = n / 2;
        for (int h = n / 2; h > 0; h /= 2) {
            //对各个局部分组进行插入排序
            for (int i = h; i < n; i++) {
                // 将arr[i] 插入到所在分组的正确位置上
                insertI(arr, h, i);
            }
        }
        return arr;
    }

    /**
     * 将arr[i]插入到所在分组的正确位置上 arr[i]] 所在的分组为 ... arr[i-2*h],arr[i-h], arr[i+h] ...
     */
    private static void insertI(int[] arr, int h, int i) {
        int temp = arr[i];
        int k;
        for (k = i - h; k > 0 && temp < arr[k]; k -= h) {
            arr[k + h] = arr[k];
        }
        arr[k + h] = temp;
    }

}
