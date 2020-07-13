package com.panchen.classicalAlgorithm;

/**
 * @Description: 归并排序 二分思想  递归一直切割到1个位置 然后左右对比 合并的过程
 * @author: chenp
 * @date: 2020/07/13 14:18
 */
public class MergeSort {


    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            arr = mergeSort(arr, left, mid);

            arr = mergeSort(arr, mid + 1, right);
            //进行合并
            merge(arr, left, mid, right);
        }
        return arr;
    }

    //核心
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] a = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 左右2块组合
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                a[k++] = arr[i++];
            } else {
                a[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            a[k++] = arr[i++];
        }
        while (j <= right) {
            a[k++] = arr[j++];
        }
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = a[i];
        }
    }
}
