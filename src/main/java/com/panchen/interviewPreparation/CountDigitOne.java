package com.panchen.interviewPreparation;

/**
 * @Description: 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 示例:
 * <p>
 * 输入: 13 输出: 6 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * <p>
 * 解题思路 f(n))函数的意思是1～n这n个整数的十进制表示中1出现的次数，将n拆分为两部分，最高一位的数字high和其他位的数字last，分别判断情况后将结果相加，看例子更加简单。
 * <p>
 * 例子如n=1234，high=1, pow=1000, last=234
 * <p>
 * 可以将数字范围分成两部分1~999和1000~1234
 * <p>
 * 1~999这个范围1的个数是f(pow-1) 1000~1234这个范围1的个数需要分为两部分： 千分位是1的个数：千分位为1的个数刚好就是234+1(last+1)，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是234中出现1的个数，为f(last) 所以全部加起来是f(pow-1) + last + 1 + f(last);
 * <p>
 * 例子如3234，high=3, pow=1000, last=234
 * <p>
 * 可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
 * <p>
 * 1~999这个范围1的个数是f(pow-1) 1000~1999这个范围1的个数需要分为两部分： 千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
 * 其他位是1的个数：即是999中出现1的个数，为f(pow-1) 2000~2999这个范围1的个数是f(pow-1) 3000~3234这个范围1的个数是f(last) 所以全部加起来是pow
 * + high*f(pow-1) + f(last);
 * <p>
 * 作者：xujunyi 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/javadi-gui-by-xujunyi/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: chenp
 * @date: 2020/03/31 11:57
 */
public class CountDigitOne {

    public int solution(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n <= 0) {
            return 0;
        }
        String s = String.valueOf(n);
        int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }

}
