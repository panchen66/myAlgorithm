package com.panchen.leetcode;

/**
 * @Description: 8
 * @author: chenp
 * @date: 2020/01/14 17:15
 */
public class AsciiToInteger {

    public static void main(String[] args) {
        char c = ' ';
        char a = '0';
        System.out.println(c < a);
        System.out.println(myAtoi(" -12313 "));
    }


    public static int myAtoi(String str) {
        int i = 0;
        int j;
        int len = str.length();
        boolean negative = false;
        for (; i < len; i++) {
            if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }

        }
        for (j = i; j < len; j++) {
            if ('0' <= str.charAt(j) && '9' >= str.charAt(j)) {
                continue;
            } else {
                break;
            }

        }

        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;


    }
}
