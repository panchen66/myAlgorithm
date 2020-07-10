package com.panchen.newStart;

/**
 * @Description:给定一个无序的整数数组，找到其中最长上升子序列的长度。 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18] 输出: 4 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 经典DP  dp记录的是当前位置最优的子序列数 如何达到最优条件呢 即到index在自己前面的 并且是比自己小的 最优位置'
 * @author: chenp
 * @date: 2020/07/09 18:58
 */
public class LengthOfLIS {


    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int[] dp = new int[length];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }


}
