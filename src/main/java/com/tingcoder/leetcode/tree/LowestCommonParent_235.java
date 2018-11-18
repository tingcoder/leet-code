package com.tingcoder.leetcode.tree;

import com.tingcoder.leetcode.base.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 */
public class LowestCommonParent_235 {

    /**
     * 非递归写法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode rootNode = root;
        while (true) {
            if (rootNode.val > p.val && rootNode.val > q.val) {
                rootNode = rootNode.left;
            } else if (rootNode.val < p.val && rootNode.val < q.val) {
                rootNode = rootNode.right;
            } else {
                break;
            }
        }
        return rootNode;
    }

    /**
     * 递归写法
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRecurse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorRecurse(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorRecurse(root.right, p, q);
        } else {
            return root;
        }
    }
}