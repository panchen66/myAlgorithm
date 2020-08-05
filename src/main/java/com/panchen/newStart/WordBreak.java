package com.panchen.newStart;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:leetcode 139. 单词拆分 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s
 * 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"] 输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet
 * code"。 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为 "applepenapple"
 * 可以被拆分成 "apple pen apple"。      注意你可以重复使用字典中的单词。 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出: false
 * <p>
 * @author: chenp 经典动规  直接找了题解  RED_DEVIL同学写得很赞
 * @date: 2020/08/05 18:37
 */
public class WordBreak {


    public HashMap<String, Boolean> hash = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        //方便check，构建一个哈希表
        for (String word : wordDict) {
            hash.put(word, true);
        }

        //初始化
        dp[0] = true;

        //遍历
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[j] = dp[i] && check(s.substring(i, j));
                if (dp[j]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean check(String s) {
        return hash.getOrDefault(s, false);
    }


}
