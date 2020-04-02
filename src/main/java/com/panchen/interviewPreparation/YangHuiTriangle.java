package com.panchen.interviewPreparation;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description: 杨辉三角
 * <p>
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 示例:
 * <p>
 * 输入: 3 输出: [1,3,3,1]
 * @author: chenp
 * @date: 2020/04/02 16:36
 */
public class YangHuiTriangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3)));
    }

    private static int[] solution(int k) {
        if (k < 2) {
            return new int[1];
        }
        int[] pre = null;
        for (int i = 0; i <= k; i++) {
            int l = i + 1;
            int[] res = new int[l];
            for (int m = l; m > 0; m--) {
                if (m == 1 || m == l) {
                    res[m - 1] = 1;
                } else {
                    res[m - 1] = pre[m - 1 - 1] + pre[m - 1];
                }
            }
            pre = res;
        }
        return pre;
    }


}
