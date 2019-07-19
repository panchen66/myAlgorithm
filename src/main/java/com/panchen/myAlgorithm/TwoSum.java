package com.panchen.myAlgorithm;

/**
 * 给定一个有序数组和一个整数，返回两个数组的索引，
 * 这两个索引指向的数字的加和等于指定的整数。需要最优的算法，分析算法的空间和时间复杂度
 * 
 * @author pc
 *
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (i != j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            }

            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }

            if (numbers[i] + numbers[j] > target) {
                j--;
                continue;
            }
        }

        return new int[] {i, j};
    }
}
