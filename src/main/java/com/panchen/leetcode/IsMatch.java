package com.panchen.leetcode;


/**
 * @Description: leetCode 10
 * @author: chenp
 * @date: 2020/01/15 18:02
 */
public class IsMatch {

    public static void main(String[] args) {
        String text = "1234567";
        String pattern = "1234.*";
        if (isMatch(text, pattern)) {
            System.out.printf("isMatch!");
        }
    }

    private static boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
                printArrays(dp);
            }
        }
        return dp[0][0];

    }


    private static void printArrays(boolean[][] dp) {
        for (int x = 0; x < dp.length; x++) {
            for (int y = 0; y < dp[x].length; y++) {
                System.out.print(dp[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }


}
