package com.panchen.newStart;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: leetcode 46 全排列 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * <p>
 * <p>
 * 此题深度优先遍历 回溯 结合
 * <p>
 * 时间复杂度: 共有n!个叶子节点  组合叶子节点需要n次 n*n！ 空间复杂度  就是其结果集 n！* n
 * @author: chenp
 * @date: 2020/06/22 19:10
 */
public class Permute {


    public List<List<Integer>> permute(int[] nums) {
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
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 递归里套回溯
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
