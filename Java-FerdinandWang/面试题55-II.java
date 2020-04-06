/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题55-II 平衡二叉树
 * 题目链接:https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        // 根节点为空直接返回true
        if(root == null){
            return true;
        }

        // 左子树深度-右子树深度的绝对值<=1且左子树和右子树均为平衡二叉树
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 
                && isBalanced(root.right)
                && isBalanced(root.left);
        
    }

    //计算树的深度
    static int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}