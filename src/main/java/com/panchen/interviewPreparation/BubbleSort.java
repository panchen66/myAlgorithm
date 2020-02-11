package com.panchen.interviewPreparation;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * （1）冒泡排序是比较相邻位置的两个数，而选择排序是按顺序比较，找最大值或者最小值；
 * <p>
 * （2）冒泡排序每一轮比较后，位置不对都需要换位置，选择排序每一轮比较都只需要换一次位置；
 * <p>
 * （3）冒泡排序是通过数去找位置，选择排序是给定位置去找数；
 * <p>
 * 冒泡排序优缺点：优点:比较简单，空间复杂度较低，是稳定的； 缺点:时间复杂度太高，效率慢；
 * <p>
 * 选择排序优缺点：优点：一轮比较只需要换一次位置；
 * <p>
 * 缺点：效率慢，不稳定（举个例子5，8，5，2，9   我们知道第一遍选择第一个元素5会和2交换，那么原序列中2个5的相对位置前后顺序就破坏了）。
 * @author: chenp
 * @date: 2020/02/11 14:17
 */
public class BubbleSort {


    private static int[] bubbleSort(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return nums;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0, subLen = len - 1 - i; j < subLen; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

}
