package com.panchen.newStart;

/**
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 刚刷了题 括号闭环的动态规划题后 赶紧再来一题动态规划
 * <p>
 * 思路： d(i)=跳跃次数  i=当前位数
 * <p>
 * d(i)=Min(d(i-1))+1
 * @author: chenp
 * @date: 2020/05/04 16:26
 */
public class NumDupDigitsAtMostN {

    public static void main(String[] args) {
        int[] data = {2, 3, 1, 1, 4};
        System.out.println(numDupDigitsAtMostN2(data));
    }

    //这个写法直接超时了
    private static int numDupDigitsAtMostN(int[] data) {
        if (data.length <= 1) {
            return 0;
        }
        int[] dp = new int[data.length];
        //可预估
        dp[0] = 0;
        dp[1] = 1;
        //从1号位开始推进
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + data[j] >= i) {
                    if (0 == dp[i]) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }

                }
            }
        }
        return dp[data.length - 1];
    }


    //靠 发现我没复用之前的dp
    //这思路彻底不对 ！！！！！！！！！！！！
    // 能到i-1可能也能到i
    private static int numDupDigitsAtMostN2(int[] data) {
        if (data.length <= 1) {
            return 0;
        }
        int[] dp = new int[data.length];
        //可预估
        dp[0] = 0;
        dp[1] = 1;
        int last = 0;
        //从1号位开始推进
        for (int i = 1; i < data.length; i++) {
            for (int j = last; j < i; j++) {
                if (j + data[j] >= i) {
                    if (0 == dp[i]) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                    last = j;
                }
            }
        }
        return dp[data.length - 1];
    }

    //想不出来了 cv了个哥们的实现  加个 走了n步剩余的能量步数
  /*  作者：188380780
    链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tan-xin-shi-yao-de-wo-zhen-de-bu-hui-tan-a-zhi-nen/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    private static int numDupDigitsAtMostN3(int[] nums) {
        if (nums.length == 1) {
            return 1;  // 一个格子跳啥了还
        }
        int[] step = new int[nums.length], dp = new int[nums.length];
        step[1] = nums[0];  // 第一步可以达到的最大位置，前面已经保证至少 2 格
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = step[dp[i - 1]] >= i ? dp[i - 1] : dp[i - 1] + 1;
            // 假如前一个格子所花的步数能达到的最大位置 >= 当前位置，即前一个步数也可以到当前位置
            // 不能到达。不能到达就再走一步！
            if (dp[i] + 1 < nums.length)  // 步数可能溢出，但是溢出的数据是没有意义的（一定可以在 n-1 步到达终点）
            {
                step[dp[i] + 1] = Math.max(step[dp[i] + 1], i + nums[i]);
            }
            // 这里计算的是从当前格子在走一步所能到达的最大距离
            // 假如超过之前存储的最大步数，则更新
        }
        return dp[nums.length - 1];

    }

}
