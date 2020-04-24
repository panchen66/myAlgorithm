package com.panchen.newStart;

/**
 * @Description: leetcode: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是
 * 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。 示例 2:
 * <p>
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 思考 : 买入/卖出一次 体会题意即求 求数组index a-b最大差(a>b)
 * <p>
 * 看了题解 ：我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时
 * <p>
 * 切入点转变为 求各天卖出股票的最大差值
 * <p>
 * 本质 减少循环 方法 抽象目的
 * @author: chenp
 * @date: 2020/04/23 18:51
 */
public class MaxProfit {


    public static void main(String[] args) {

    }

    public int solution(int[] prices) {
        int res = 0;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }
        return res;
    }

}
