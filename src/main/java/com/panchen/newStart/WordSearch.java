package com.panchen.newStart;

/**
 * @Description: leetcode 79. 单词搜索 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * <p>
 * 给定 word = "ABCCED", 返回 true 给定 word = "SEE", 返回 true 给定 word = "ABCB", 返回 false
 *
 *
 * 思考:回溯
 *
 * @author: chenp
 * @date: 2020/07/14 15:30
 */
public class WordSearch {


    public static void main(String[] args) {
        char[][] board =
            {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
            };
        String word = "ABCCED";
        System.out.println(wordSearch(board, word));
    }

    public static boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i <= board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    return dfs(board, word, 0, i, j);
                }

            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int start, int i, int j) {
        if (start == word.length()) {
            return true;
        }
        for (int m = 0; m < board.length; m++) {
            if (word.charAt(start) == board[m][j]) {
                if (dfs(board, word, ++start, m, j)) {
                    return true;
                }
            }
        }
        for (int m = 0; m < board[i].length; m++) {
            if (word.charAt(start) == board[i][m]) {
                if (dfs(board, word, ++start, i, m)) {
                    return true;
                }
            }
        }
        return false;

    }
}

