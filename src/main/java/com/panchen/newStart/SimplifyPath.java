package com.panchen.newStart;

import java.util.Stack;

/**
 * @Description: 71. 简化路径
 * <p>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux /
 * Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："/home/" 输出："/home" 解释：注意，最后一个目录名后面没有斜杠。 示例 2：
 * <p>
 * 输入："/../" 输出："/" 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。 示例 3：
 * <p>
 * 输入："/home//foo/" 输出："/home/foo" 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。 示例 4：
 * <p>
 * 输入："/a/./b/../../c/" 输出："/c" 示例 5：
 * <p>
 * 输入："/a/../../b/../c//.//" 输出："/c" 示例 6：
 * <p>
 * 输入："/a//b////c/d//././/.." 输出："/a/b/c"
 * <p>
 * 直接看了解答 注释很清晰 给这同学点个赞 核心思想用栈
 * @author: chenp
 * @date: 2020/07/29 18:55
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果数组非空,且访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..")) {
                // 这里用到增强型 for 循环不能同时判断，需要再次判空
                // 而普通 for 循环则可写成( !stack.isEmpty() && s.equals("..") )
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append("/" + stack.get(i));
        }
        return ans.toString();
    }

}
