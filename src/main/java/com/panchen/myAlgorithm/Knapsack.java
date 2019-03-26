package com.panchen.myAlgorithm;

/**
 * 01背包/完全背包/多重背包
 * 
 * @author pc
 *
 */
public class Knapsack {


    public static void main(String[] args) {
        int m = 10;
        int w[] = {3, 4, 5};
        int v[] = {4, 5, 6};
        int l[] = {1, 2, 3};
        int c[][] = backPack(m, w, v, l);
        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * @param m 表示背包的最大容量
     * @param w 表示商品重量数组
     * @param v 表示商品价值数组
     * @param l 表示商品限制数量
     */
    public static int[][] backPack(int m, int[] w, int[] v, int[] l) {

        int s = w.length;
        int[][] dp = new int[s + 1][m + 1];

        // 当前商品
        for (int i = 1; i < s; i++) {

            // 当前背包max
            for (int j = 1; j <= m; j++) {

                // 对比max跟 l*w
                for (int k = 1; k <= l[i - 1] && k * w[i - 1] <= j; k++) {
                    
                    if (dp[i][j] < dp[i - 1][j - k * w[i - 1]] + k * v[i - 1]) {
                        dp[i][j] = dp[i - 1][j - k * w[i - 1]] + k * v[i - 1];
                        
                    }
                    
                }

            }

        }

        return dp;
    }

}

