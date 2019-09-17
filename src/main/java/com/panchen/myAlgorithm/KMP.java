package com.panchen.myAlgorithm;

import com.google.common.base.Strings;

/**
 * 
 * @Description:
 * 
 *               用来解决字符串查找的问题，可以在一个字符串（S）中查找一个子串（W）出现的位置
 *               
 *               
 *               参考：https://blog.csdn.net/BaiDingLT/article/details/69808221
 *               参考：https://blog.csdn.net/v_july_v/article/details/7041827
 * @author: chenp
 *
 * @date: 2019/09/16 17:16:45
 */
public class KMP {

    public static void main(String[] args) {
        String a = "abbaabbaaba";
        String b = "abbaaba";
        int[] res = getNext(b);
        for (int i : res) {
            System.out.println(i);
        }
        System.out.println(kmp(a, b));
    }

    private static int kmp(String a, String b) {
        int i = 0, j = 0;
        char[] src = a.toCharArray();
        char[] ptn = b.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = getNext(b);
        while (i < sLen && j < pLen) {
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;

    }



    private static int[] getNext(String s) {
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        char[] sArray = s.toCharArray();
        int sArrayLen = sArray.length;
        int[] next = new int[sArrayLen];
        int k = -1;
        int j = 0;
        next[0] = -1;
        // k维持了个前缀相同点的下一位 j维持了当前遍历数组的最大位
        while (j < sArrayLen - 1) {
            if (k == -1 || sArray[j] == sArray[k]) {
                next[++j] = ++k;
            } else {
                // 为何递归前缀索引k = next[k]，就能找到长度更短的相同前缀后缀呢?
                // 注意这时候j并没有向后移动，也就意味着下一次循环中p[j]和p[k’]需要继续进行比较，如果还是不相等，那么就要继续k = next[k];(即k =
                // next[next[k’]])递归就体现在这里，如果一直不相等，最后的k会变为-1，那么这个时候”递归”就结束了，执行next[++j] =
                // ++k(k有初始化为0，next[j+1]也被赋值为0，并且j游标也后移了一位，可以继续初始化next数组了
                k = next[k];
            }
        }
        return next;

    }



}
