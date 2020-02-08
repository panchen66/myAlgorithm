package com.panchen.interviewPreparation;

import java.util.Arrays;

/**
 * @Description: 折半查找
 * @author: chenp
 * @date: 2020/02/08 18:01
 */
public class BinarySort {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySort(array, 6));
    }

    private static int binarySort(int[] array, int key) {
        int half = array.length / 2;
        if (array[half] > key) {
            binarySort(Arrays.copyOfRange(array, 0, half - 1), key);
        } else if (array[half] < key) {
            binarySort(Arrays.copyOfRange(array, half + 1, array.length), key);
        } else {
            return half;
        }
        return -1;
    }


}
