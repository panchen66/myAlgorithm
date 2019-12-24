package com.panchen.leetcode;

import java.util.Queue;

/**
 * @Description: leetcode 5
 * @author: chenp
 * @date: 2019/12/24 11:58
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abaca";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int resLen = 0;
        String res = null;
        boolean[][] dp = new boolean[len][len];
        for (int r = 0; r < len; r++) {
            for (int l = 0; l <= r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - (l + 1) <= 1 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l >= resLen) {
                        resLen = r - l;
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }

}
