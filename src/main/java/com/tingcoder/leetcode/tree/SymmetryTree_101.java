package com.tingcoder.leetcode.tree;

import com.tingcoder.leetcode.base.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 */
public class SymmetryTree_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //解法1：递归的方式
        //return isSymmetric(root.left, root.right);

        //解法2：使用迭代的方式
        return isSymmetricIter(root);
    }

    /**
     * 使用迭代的方式
     *
     * @param root
     * @return
     */
    private boolean isSymmetricIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        stack.add(root.left);
        stack.add(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left.val != right.val) {
                return false;
            }

            //left.left <-> right.right
            if (left.left != null && right.right == null) {
                return false;
            }
            if (left.left == null && right.right != null) {
                return false;
            }
            if (left.left != null && right.right != null) {
                stack.push(left.left);
                stack.push(right.right);
            }

            //left.right <-> right.left
            if (left.right == null && right.left != null) {
                return false;
            }
            if (left.right != null && right.left == null) {
                return false;
            }
            if (left.right != null && right.left != null) {
                stack.push(left.right);
                stack.push(right.left);
            }
        }
        return true;
    }

    /**
     * 使用递归的方式
     *
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
