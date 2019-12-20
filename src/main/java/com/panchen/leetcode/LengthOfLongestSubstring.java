package com.panchen.leetcode;

import java.util.HashMap;

/**
 * @Description: leetcode 3
 * @author: chenp
 * @date: 2019/12/20 17:58
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        System.out.println(solution("aaccbdb"));
    }

    public static int solution(String s) {
        if (0 >= s.length()) {
            return 0;
        }
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
