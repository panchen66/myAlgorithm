package com.panchen.classicalAlgorithm;

/**
 * @Description:
 * @author: chenp
 * @date: 2020/07/13 16:09
 */
public class CountSort {

    public static int[] countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        int max = arr[0];
        // 寻找数组的最大值
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //创建大小为max的临时数组
        int[] temp = new int[max + 1];
        //统计元素i出现的次数
        for (int i = 0; i < n; i++) {
            temp[arr[i]]++;
        }
        int k = 0;
        //把临时数组统计好的数据汇总到原数组
        for (int i = 0; i <= max; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[k++] = i;
            }
        }
        return arr;
    }
}
