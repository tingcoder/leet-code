package com.tingcoder.leetcode.tree;

import com.tingcoder.leetcode.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestor_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lr = lowestCommonAncestor(root.left, p, q);
        TreeNode rr = lowestCommonAncestor(root.right, p, q);
        if (lr != null && rr != null) {
            return root;
        }
        return lr == null ? rr : lr;
    }
}