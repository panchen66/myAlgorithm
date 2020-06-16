package com.panchen.newStart;

/**
 * @Description: 42. 接雨水 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * <p>
 * 思考: leetcode 有张图描述的 看了后 第一反应 选点看自己的左右是否比自己高 然后不断发散
 * <p>
 * 感觉可以动规做
 * @author: chenp
 * @date: 2020/05/09 18:09
 */
public class Trap {

    public static void main(String[] args) {
        int[] data = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution(data));
    }


    private static int solution(int[] data) {
        int left = 0;
        int right = data.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (data[left] < data[right]) {
                if (data[left] >= leftMax) {
                    leftMax = data[left];
                } else {
                    res += (leftMax
                        - data[left]);
                }
                ++left;
            } else {
                if (data[right] >= rightMax) {
                    rightMax = data[right];
                } else {
                    res += (rightMax
                        - data[right]);
                }
                --right;
            }
        }
        return res;
    }

}
