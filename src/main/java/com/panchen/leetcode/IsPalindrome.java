package com.panchen.leetcode;

/**
 * @Description: 9
 * @author: chenp
 * @date: 2020/01/14 18:08
 */
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(13231));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

}
