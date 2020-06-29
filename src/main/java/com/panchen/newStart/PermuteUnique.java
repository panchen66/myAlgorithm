package com.panchen.newStart;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 全排列2 输入: [1,1,2] 输出: [ [1,1,2], [1,2,1], [2,1,1] ]
 * <p>
 * 拓展于全排列1
 * @author: chenp
 * @date: 2020/06/28 17:42
 */
public class PermuteUnique {

    public List<List<Integer>> PermuteUnique(int[] nums) {
        int length = nums.length;
        //结果集
        List<List<Integer>> res = new LinkedList<>();
        if (length == 0) {
            return res;
        }
        //用来确定哪些数被用过了
        boolean[] used = new boolean[length];

        //tmp
        List<Integer> path = new LinkedList<>();

        dfs(nums, length, 0, path, used, res);
        return res;

    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used,
        List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }
            //判断分支 即树的分叉口 上一个点 跟 当前点是否一样      并且是被撤销了的
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);
            // 递归里套回溯
            used[i] = false;
            path.remove(path.size() - 1);

        }
    }

}
