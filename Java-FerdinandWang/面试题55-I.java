/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题55-I 二叉树的深度
 * 题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//本题目的主要思路是递归，根节点的深度 = max(左子树深度，右子树深度)+ 1
class Solution {
   
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
}