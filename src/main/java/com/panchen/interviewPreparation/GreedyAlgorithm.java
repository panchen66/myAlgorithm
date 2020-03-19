package com.panchen.interviewPreparation;

/**
 * @Description: 贪心算法  在对问题求解时，总是做出在当前看来是最好的选择
 * <p>
 * 贪心算法的经典案例：
 * <p>
 * 跳跃游戏：
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 例如：[2,3,1,1,4,2,2,1]     很明显最短路线：2跳到3的位置，再跳到4的位置，然后就可以跳到最后。
 * @author: chenp
 * @date: 2020/03/18 16:29
 */
public class GreedyAlgorithm {


    public static void main(String[] args) {
        int[] data = {2, 3, 1, 1, 4, 2, 2, 1};
        System.out.println(solution(data));
    }

    private static int solution(int[] nums) {
        int jump = 1;
        int pos = nums[0];
        int maxPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i + nums[i] > pos) {
                pos = i + nums[i];
            }
            if (pos >= nums.length - 1) {
                return jump + 1;
            }
            if (i == maxPos) {
                jump++;
                maxPos = pos;
            }
        }
        return jump;
    }

}
