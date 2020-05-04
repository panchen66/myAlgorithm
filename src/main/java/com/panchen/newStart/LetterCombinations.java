package com.panchen.newStart;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: leetcode17:电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 看了官方的题解
 * <p>
 *
 * dfs过程
 *
 * 回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
 * @author: chenp
 * @date: 2020/04/27 17:57
 */
public class LetterCombinations {

    private String letterMap[] = {
        " ",    //0
        "",     //1
        "abc",  //2
        "def",  //3
        "ghi",  //4
        "jkl",  //5
        "mno",  //6
        "pqrs", //7
        "tuv",  //8
        "wxyz"  //9
    };

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> res = letterCombinations.letterCombinations("23");
        for (String s : res) {
            System.out.println(s);
        }
    }

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }

        return;
    }


}
