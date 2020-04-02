package com.panchen.interviewPreparation;

/**
 * @Description: 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
 * <p>
 * 'W' 表示一堵墙 'E' 表示一个敌人 '0'（数字 0）表示一个空位
 * <p>
 * 示例:
 * <p>
 * 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]] 输出: 3 解释: 对于如下网格
 * <p>
 * 0 E 0 0 E 0 W E 0 E 0 0
 * <p>
 * 假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
 * @author: chenp
 * @date: 2020/03/28 19:30
 */
public class MaxKilledEnemies {

    public static void main(String[] args) {
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(maxKilledEnemies(grid));
    }

    public static int maxKilledEnemies(char[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ('0' == (grid[i][j])) {
                    int yHig = 0;
                    int yLow = 0;
                    int xHig = 0;
                    int xLow = 0;
                    for (int m = 0; m < grid[i].length; m++) {
                        if (m < j) {
                            if ('E' == (grid[i][m])) {
                                xLow++;
                            }
                            if ('W' == (grid[i][m])) {
                                xLow = 0;
                            }
                        }
                        if (m > j) {
                            if ('E' == (grid[i][m])) {
                                xHig++;
                            }
                            if ('W' == (grid[i][m])) {
                                break;
                            }
                        }
                    }
                    for (int m = 0; m < i; m++) {
                        if (m < i) {
                            if ('E' == (grid[m][j])) {
                                yHig++;
                            }
                            if ('W' == (grid[m][j])) {
                                yHig = 0;
                            }
                        }
                        if (m > i) {
                            if ('E' == (grid[m][j])) {
                                yLow++;
                            }
                            if ('W' == (grid[m][j])) {
                                break;
                            }
                        }
                    }
                    int res = yHig + yLow + xHig + xLow;
                    if (max >= res) {
                        break;
                    }
                    max = max > res ? max : res;
                }
            }
        }
        return max;
    }
}
