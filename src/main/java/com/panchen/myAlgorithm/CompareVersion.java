package com.panchen.myAlgorithm;

import javafx.util.Pair;

/**
 * @Description: 165. 比较版本号 比较两个版本号 version1 和 version2。 如果 version1 > version2 返回 1，如果 version1 < version2
 * 返回 -1， 除此之外返回 0。
 * <p>
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 * <p>
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * <p>
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * <p>
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。  
 * <p>
 * 示例 1:
 * <p>
 * 输入: version1 = "0.1", version2 = "1.1" 输出: -1 示例 2:
 * <p>
 * 输入: version1 = "1.0.1", version2 = "1" 输出: 1 示例 3:
 * <p>
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3" 输出: -1 示例 4：
 * <p>
 * 输入：version1 = "1.01", version2 = "1.001" 输出：0 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。 示例 5：
 * <p>
 * 输入：version1 = "1.0", version2 = "1.0.0" 输出：0 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 * <p>
 * <p>
 * 第一反应 先根据'.'来进行拆分  然后线性对比
 * <p>
 * LAwLi3t 同学的实现   递归  双指针
 * @author: chenp
 * @date: 2020/08/19 10:41
 */
public class CompareVersion {


    public static void main(String[] args) {
        CompareVersion CompareVersion = new CompareVersion();
        System.out.println(CompareVersion.compareVersion("7.5.2.4", "7.5.3"));
    }

    public int compareVersion(String version1, String version2) {
        return compare(version1, version2, 0, 0);
    }

    public int compare(String v1, String v2, int index1, int index2) {
        int len1 = v1.length(), len2 = v2.length();
        if (index1 >= len1 && index2 >= len2) {
            return 0;
        }
        if (index1 >= len1 && index2 < len2) {
            return compare("0", v2.substring(index2, len2), 0, 0);
        }
        if (index2 >= len2 && index1 < len1) {
            return compare(v1.substring(index1, len1), "0", 0, 0);
        }
        int i = index1, j = index2;
        while (i < len1 && v1.charAt(i) != '.') {
            i++;
        }
        while (j < len2 && v2.charAt(j) != '.') {
            j++;
        }
        int n1 = Integer.valueOf(v1.substring(index1, i));
        int n2 = Integer.valueOf(v2.substring(index2, j));
        if (n1 == n2) {
            return compare(v1, v2, i + 1, j + 1);
        }
        return n1 > n2 ? 1 : -1;
    }


}
