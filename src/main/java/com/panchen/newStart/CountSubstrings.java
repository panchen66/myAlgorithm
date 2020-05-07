package com.panchen.newStart;

/**
 * @Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c". 示例 2:
 * <p>
 * 输入: "aaa" 输出: 6 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 再来一题经典动规！
 * <p>
 * 首先解释下回文串(palindromic string)是指这个字符串无论从左读还是从右读,所读的顺序是一样的！
 * @author: chenp
 * @date: 2020/05/07 18:00
 */
public class CountSubstrings {


    //  干了一天活 着实不愿意自己写了 。。  思路理得很清楚了
    //
    //作者：ustcyyw
    //链接：https://leetcode-cn.com/problems/palindromic-substrings/solution/647java-bao-li-dpzhong-xin-kuo-zhan-xiang-jie-by-u/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int countSubstrings2(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean[][] flag = new boolean[chars.length][chars.length];
        for (int j = 0; j < chars.length; j++) {
            for (int i = j; i >= 0; i--) {
       //判断新的头尾 是否一样   一样的话 考虑 内括号里 的 情况1.中间就一位 类似aba  情况2.abba 即去头尾也是回文的情况
                if (chars[i] == chars[j] && (j - i < 2 || flag[i + 1][j - 1])) {
                    flag[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }

}
