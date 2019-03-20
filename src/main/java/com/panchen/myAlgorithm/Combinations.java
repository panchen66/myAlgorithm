package com.panchen.myAlgorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

public class Combinations {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || n < k) {
            return result;
        }
        combine(n, k, 1, new ArrayList<>());
        return result;
    }

    private void combine(int n, int k, int index, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n - k + 1; i++) {
            temp.add(i);
            combine(n, k - 1, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
