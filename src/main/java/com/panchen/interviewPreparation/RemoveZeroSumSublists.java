package com.panchen.interviewPreparation;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1] 输出：[3,1] 提示：答案 [1,2,1] 也是正确的。 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4] 输出：[1,2,4] 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2] 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 * <p>
 * <p>* @author: chenp
 * @date: 2020/04/09 17:58
 */
public class RemoveZeroSumSublists {

    @Getter
    @Setter
    class ListNode {

        public ListNode(int data) {
            this.val = data;
        }

        private ListNode next;

        private int val;

    }


    public static void main(String[] args) {

    }

    /**
     * 1.建立一个HashMap，前面多项和sum为key，此节点d作为value，组成 (sum,d) 如果出现好多相同的(sum,d)，后面的覆盖前面的
     * 2.第二遍遍历哈希表，如果sum和哈希表里面的sum相同，找到sum对应的结点的next作为d.next; 3.返回链表的头结点
     *
     * 摘自 leetcode
     */
    private ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }
        return dummy.next;
    }

}
