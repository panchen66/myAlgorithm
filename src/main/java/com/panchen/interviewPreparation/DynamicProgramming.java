package com.panchen.interviewPreparation;

/**
 * @Description: 动态规划学习
 * <p>
 * 之前学习了贪心算法 贪心是只考虑了当前位置的最优点
 * <p>
 * 如果贪心算法是局部最优  那么动规就是根据一定的状态转义方程来求全局最优
 * <p>
 * dp是自带剪枝的 这个很容易理解 每步都是最优
 * <p>
 * 如何设计dp
 * <p>
 * 拆分结果为n个阶段  理解各个阶段的 状态变化
 * <p>
 * 可以理解为 dp=递归+缓存
 * <p>
 * <p>
 * 例题： 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。
 * <p>
 * 1 3 3/ 2 1 3/ 2 2 1/
 * <p>
 * 能够获得的最大价值为：11。
 * <p>
 * <p>
 * 转换阶段为 从左上到右下可能能到的所有格子   状态为 每个格子上的最大价值
 * @author: chenp
 * @date: 2020/03/20 15:21
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        int[][] data = {{1, 3, 3}, {2, 1, 3}, {2, 2, 1}};
        System.out.println(solution(data));
    }


    private static int solution(int[][] data) {
        int[][] resultMap = new int[data.length + 1][data.length + 1];
        for (int i = 1; i < resultMap.length; i++) {
            for (int j = 1; j < resultMap.length; j++) {
                resultMap[i][j] =
                    Math.max(resultMap[i - 1][j], resultMap[i][j - 1]) + data[i - 1][j - 1];
            }

        }
        return resultMap[data.length][data.length];
    }

}
