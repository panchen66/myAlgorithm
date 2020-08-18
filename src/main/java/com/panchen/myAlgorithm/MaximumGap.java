package com.panchen.myAlgorithm;

/**
 * @Description: 164. 最大间距 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1] 输出: 3 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 示例 2:
 * <p>
 * 输入: [10] 输出: 0 解释: 数组元素个数小于 2，因此返回 0。
 * <p>
 *
 * 桶排序 摘自程序员吴师兄
 *
 * @author: chenp
 * @date: 2020/08/18 18:26
 */
public class MaximumGap {


    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{5, 33, 12, 19, 222, 3333, 1, 11111}));
    }

    private static class Bucket {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        // 分配桶的长度和个数是桶排序的关键
        // 在 n 个数下，形成的两两相邻区间是 n - 1 个，比如 [2,4,6,8] 这里
        // 有 4 个数，但是只有 3 个区间，[2,4], [4,6], [6,8]
        // 因此，桶长度 = 区间总长度 / 区间总个数 = (max - min) / (nums.length - 1)
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));

        // 上面得到了桶的长度，我们就可以以此来确定桶的个数
        // 桶个数 = 区间长度 / 桶长度
        // 这里考虑到实现的方便，多加了一个桶，为什么？
        // 还是举上面的例子，[2,4,6,8], 桶的长度 = (8 - 2) / (4 - 1) = 2
        //                           桶的个数 = (8 - 2) / 2 = 3
        // 已知一个元素，需要定位到桶的时候，一般是 (当前元素 - 最小值) / 桶长度
        // 这里其实利用了整数除不尽向下取整的性质
        // 但是上面的例子，如果当前元素是 8 的话 (8 - 2) / 2 = 3，对应到 3 号桶
        //              如果当前元素是 2 的话 (2 - 2) / 2 = 0，对应到 0 号桶
        // 你会发现我们有 0,1,2,3 号桶，实际用到的桶是 4 个，而不是 3 个
        // 透过例子应该很好理解，但是如果要说根本原因，其实是开闭区间的问题
        // 这里其实 0,1,2 号桶对应的区间是 [2,4),[4,6),[6,8)
        // 那 8 怎么办？多加一个桶呗，3 号桶对应区间 [8,10)
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];

        for (int i = 0; i < nums.length; ++i) {
            int loc = (nums[i] - min) / bucketSize;

            if (buckets[loc] == null) {
                buckets[loc] = new Bucket();
            }

            buckets[loc].min = Math.min(buckets[loc].min, nums[i]);
            buckets[loc].max = Math.max(buckets[loc].max, nums[i]);
        }

        int previousMax = Integer.MAX_VALUE;
        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < buckets.length; ++i) {
            if (buckets[i] != null && previousMax != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, buckets[i].min - previousMax);
            }

            if (buckets[i] != null) {
                previousMax = buckets[i].max;
                maxGap = Math.max(maxGap, buckets[i].max - buckets[i].min);
            }
        }

        return maxGap;
    }

}
