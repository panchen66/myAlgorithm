package com.panchen.interviewPreparation;


/**
 * @Description:
 * @author: chenp
 * @date: 2020/03/31 10:41
 */
public class MinDiffInBST {

    class TreeNode {

        Integer val;
        TreeNode left;
        TreeNode right;
    }


    Integer prev, ans;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null) {
            ans = Math.min(ans, node.val - prev);
        }
        prev = node.val;
        dfs(node.right);
    }

}
