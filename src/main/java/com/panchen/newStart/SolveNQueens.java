package com.panchen.newStart;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 继全排列问题后  n皇后问题 如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 * <p>
 * 思路:  不能互相攻击=不能在同行同列同斜线上 不能同行 那可以从0行开始到n行结束，0行找个位置一站先 ，然后到1行找个满足条件的位置，再去2，，，直至到n 到了n后开始回溯
 * 求得所有满足的点
 * @author: chenp
 * @date: 2020/06/23 09:44
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        //棋盘抽象
        int[][] checkerboard = new int[n][n];
        //res
        List res = new ArrayList();
        backtrack(n, 0);
        return res;
    }

    private void backtrack(int maxCol, int nowRow) {
        if (nowRow >= maxCol) {
            return;
        }
        //
        for (int i = 0; i < maxCol; i++) {
            //判断是否满足无法互相攻击
            if (checkIsAttacked()) {
                //放下皇后位
                if (nowRow == maxCol) {
                    //一次结果获得了
                }
                //进行回溯
            }
        }
    }

    private boolean checkIsAttacked() {
        //todo
        return true;
    }

}
