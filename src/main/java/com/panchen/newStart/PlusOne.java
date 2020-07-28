package com.panchen.newStart;

/**
 * @Description: 66. 加一 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。 示例 2:
 * <p>
 * 输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
 * <p>
 * 倒叙遍历 没自己做 看了下别人的题解 链接：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 * @author: chenp
 * @date: 2020/07/27 18:50
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //到这里说明99->100 999->1000
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
