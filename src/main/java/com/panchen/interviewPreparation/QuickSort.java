package com.panchen.interviewPreparation;

/**
 * @Description: 快速排序
 * @author: chenp
 * @date: 2020/02/08 18:10
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num = {30, 24, 5, 58, 18, 36, 12, 42, 39};
        quickSort(num, 0, num.length - 1);
        for (int k : num) {
            System.out.print(k + ",");
        }
    }


    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int t = a[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (a[j] < t) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, end);
        quickSort(a, start, i);
        quickSort(a, i + 2, end);
    }


    public static void swap(int[] num, int i, int j) {
        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;
    }
}
