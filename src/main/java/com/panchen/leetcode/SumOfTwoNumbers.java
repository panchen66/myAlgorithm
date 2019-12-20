package com.panchen.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: leetcode :1
 * @author: chenp
 * @date: 2019/12/19 16:41
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 5, 6, 11, 32131, 34214, 11122, 333};
        System.out.println(Arrays.toString(sumOfTwoNumbers(data, 32142)));
    }


    private static int[] sumOfTwoNumbers(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer index;
            if (null != (index = map.get(diff))) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = index;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
