package com.panchen.newStart;

/**
 * @Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * <p>
 * 思考:一直没看懂题意 百度了下
 * <p>
 * https://www.cnblogs.com/ariel-dreamland/p/9138064.html
 * <p>
 * 这里的旋转 就是已某个点为边界 左右交换
 * <p>
 * 那可以想到 交换后还是 二分有序的
 * <p>
 * 然后看了博客里的解题思路 其通过枚举发现 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
 * <p>
 * 这里的话 其实就是找二分点
 * <p>
 * 在leetcode 又看到一个思路 index0直接跟index half比 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2
 * <= 5。 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。 第二类 6 7 1 2 3 4 5 这种，也就是
 * nums[start] > nums[mid]。此例子中就是 6 > 2。 这种情况下，后半部分有序。因此如果 nums[mid]
 * <target<=nums[end]，则在后半部分找，否则去前半部分找。
 * @author: chenp
 * @date: 2020/04/24 17:44
 */
public class Search {


    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution(nums, target));
    }


    private static int solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            }
            //前半部有序
            if (nums[start] <= midValue) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > midValue) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
