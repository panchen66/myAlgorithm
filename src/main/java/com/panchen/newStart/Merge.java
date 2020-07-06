package com.panchen.newStart;

/**
 * @Description: leetcode 56. 合并区间 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为
 * [1,6]. 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 思考： 转换为 比附近2个数组的 边界大小？ 并进行合并
 * @author: chenp
 * @date: 2020/07/01 18:43
 */
public class Merge {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int resIndex = 0;
        int[] pre = null;
        for (int[] arr : intervals) {
            if (null == pre) {
                pre = arr;
                continue;
            }
            if (pre[1] < arr[0]) {
                res[resIndex++] = pre;
                pre = arr;
            } else {
                pre[1] = arr[1];
            }
        }
        res[resIndex] = pre;
        return res;
    }

}
