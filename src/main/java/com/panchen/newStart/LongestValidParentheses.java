package com.panchen.newStart;

/**
 * @Description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 * <p>
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 * <p>
 * <p>
 * 第一反应 用栈 这个也比较容易实现 看了leetcode 上的解答
 * <p>
 * <p>
 * 这段话mark下:
 * <p>
 * 拿到这种题目后，不要慌，根据题目中是否有：计数、最大/最小/最长、是否存在等字眼，先判断是否可以使用动态规划解决，如果可以，然后根据上面的步骤，一步一步进行分析，尤其是最后一步这一步分析，是能否转化为子问题的关键。转化为子问题后，就能轻易得到转移方程，后面的操作就简单了。
 * <p>
 * 有些题目，动态规划不一定是最高效的解法，但是根据这个套路进行分析，一定是最快的解法。先写出来之后再考虑是否可以优化，或者其他更优的解法。
 * <p>
 * 作者：zhanganan0425 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: chenp
 * @date: 2020/04/29 19:25
 */
public class LongestValidParentheses {


    public int longestValidParentheses(String s) {
        //dp
        int dp[] = new int[s.length()];
        // res
        int res = 0;
        for (int i = 1; i < s.length(); i ++) {
            //确定计算得分边界 即感知到)
            if (')' == s.charAt(i)) {
                //情况一 前面直接有个闭环了'('
                if ('(' == s.charAt(i - 1)) {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //(())这种情况
                else if ('(' == s.charAt(i - dp[i - 1] - 1)) {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }


}
