package com.panchen.classicalAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description: 先以个位数的大小来对数据进行排序，接着以十位数的大小来多数进行排序，接着以百位数的大小……
 * <p>
 * 排到最后，就是一组有序的元素了。不过，他在以某位数进行排序的时候，是用“桶”来排序的。
 * <p>
 * 由于某位数（个位/十位….，不是一整个数）的大小范围为0-9，所以我们需要10个桶，然后把具有相同数值的数放进同一个桶里， 之后再把桶里的数按照0号桶到9号桶的顺序取出来，这样一趟下来，按照某位数的排序就完成了
 * @author: chenp
 * @date: 2020/07/13 16:34
 */
public class RadioSort {

    public static int[] radioSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        int max = arr[0];
        // 找出最大值
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // 创建10个桶
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 进行每一趟的排序，从个位数开始排
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                // 获取每个数最后第 i 位是数组
                int radio = (arr[j] / (int) Math.pow(10, i - 1)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(arr[j]);
            }
            //合并放回原数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //取出来合并了之后把桶清光数据
                bucketList.get(j).clear();
            }
        }
        return arr;
    }

}