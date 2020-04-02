package com.panchen.interviewPreparation;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @author: chenp
 * @date: 2020/02/11 14:13
 */
public class SelectionSort {

    public static String selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println(selectionSort(arr));
    }

}
