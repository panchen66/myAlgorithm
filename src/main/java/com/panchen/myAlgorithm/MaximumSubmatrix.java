package com.panchen.myAlgorithm;

import java.util.Stack;

/**
 * 
 * 
 * 求最大子矩阵大小 ps:用来统计二维数据常用嗷
 * 
 * 題目来源: 程序员代码面试指南 IT名企算法与数据结构题目最优解
 * 
 * @author panchen
 *
 */
public class MaximumSubmatrix {

    public static void main(String[] args) {
        int[][] in = {{0, 1, 1, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 1, 0, 0}};
        System.out.println(getMaximumSubmatrix(in));
    }

    static int getMaximumSubmatrix(int[][] in) {
        if (null == in || 0 >= in.length) {
            return 0;
        }
        int max = 0;
        int[] heigth = new int[in[0].length];
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                heigth[j] = in[i][j] == 0 ? 0 : ++heigth[j];
            }
            // 进行计算此层最高值
            for (int value : heigth) {
                System.out.print(value);
            }
            System.out.println();
            Stack<Integer> stack = new Stack<>();
            for (int z = 0; z < heigth.length; z++) {
                while (!stack.isEmpty() && heigth[z] <= heigth[stack.peek()]) {
                    int last = stack.pop();
                    int size = (last - ((stack.isEmpty() ? -1 : stack.peek()) + 1)) * heigth[last];
                    max = max > size ? max : size;
                }
                stack.push(z);
            }
            while (!stack.isEmpty()) {
                int last = stack.pop();
                int size = (heigth.length - ((stack.isEmpty() ? -1 : stack.peek()) + 1)) * heigth[last];
                max = max > size ? max : size;
            } ;
        }
        return max;
    }

}
