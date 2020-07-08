package com.panchen.newStart;

import java.util.Arrays;

/**
 * @Description: 75. 颜色分类 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意: 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0] 输出: [0,0,1,1,2,2]
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 思考: 进阶里的内容值得考虑 扫一次 空间o(1)  感觉是个分区的问题 ， 但区分的大小是不断变化的  那就需要记录下边界？
 * <p>
 * @author: chenp
 * @date: 2020/07/07 19:06
 */
public class SortColors {
    

    public void sortColors(int[] nums) {
        //0的右边界
        int zeroIndex = 0;
        //2的左边界
        int twoIndex = nums.length - 1;
        int i = 0;
        while (i < twoIndex) {
            if (nums[i] == 0) {
                swap(nums, i, zeroIndex++);
                //这里交换后的i位置不需要跟2一样 继续计算 ，因为肯定是1
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                //当是2的时候 跟2的位置替换 后并继续计算当前位置的值
                swap(nums, i, --twoIndex);
            }
        }


    }

    private void swap(int[] nums, int fromIndex, int toIndex) {
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }


}
