package com.panchen.myAlgorithm;

/**
 * 
 * LeetCode - 215. Kth Largest Element in an Array
 * 
 * @author pc
 *
 */
public class KthLargestElementInAnArray {


    // 找到N个无序数中的第M大的数
    public static void main(String[] args) {
        int[] so = new int[] {3, 2, 321, 654, 65, 45, 234, 233, 432, 6234};
        int m = find(so, 8, 0, so.length - 1);
        System.out.println(m);
    }

    public static int find(int[] so, int m, int start, int end) {
        if (start < end) {
            int midValue = so[start]; // 第一个元素作为中间值
            int i = start;
            int j = end + 1;
            while (true) {// 这个while循环将小于中间值的分到左边，大于中间值的分到右边
                while (i < end && so[++i] <= midValue);
                while (j > start && so[--j] >= midValue);
                if (i < j) {
                    // i，j下标对应的值交换
                    swap(so, i, j);
                } else {
                    break;
                }
            }
            swap(so, start, j);
            // 左半部分的个数
            int p = j - 1 - start < 0 ? 1 : (j - start);
            if (p >= m) {
                return find(so, m, start, j - 1);
            } else if (p + 1 == m) {
                return so[j];
            } else {
                return find(so, m - 1 - p, j + 1, end);
            }
        } else {
            return so[start];
        }
    }

    // 交换
    public static void swap(int[] so, int i, int j) {
        int t = so[i];
        so[i] = so[j];
        so[j] = t;
    }

}
