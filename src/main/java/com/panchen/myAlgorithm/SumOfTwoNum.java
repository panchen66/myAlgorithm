package com.panchen.myAlgorithm;

import java.util.HashMap;

/**
 * 
 * @Description:
 * 
 *               给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 *               你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 *               示例:
 * 
 *               给定 nums = [2, 7, 11, 15], target = 9
 * 
 *               因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 *               来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 
 * @author: chenp
 *
 * @date: 2019/09/19 15:06:32
 */
public class SumOfTwoNum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();
        int i = 0;
        while (i < nums.length) {
            if (tmpMap.containsKey(nums[i])) {
                res[0] = tmpMap.get(nums[i]);
                res[1] = nums[i];
                return res;
            }
            tmpMap.put(target - nums[i], i);
            i++;
        }
        return null;
    }


}
