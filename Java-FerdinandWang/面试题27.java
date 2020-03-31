/**
 *
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题27 二叉树的镜像
 * 题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //本题用到的主要思路是递归，交换左右子树即可
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){  //如果根节点为空，则直接返回null
            return null;
        }

        //交换左右子节点
        TreeNode tmp = root.right; 
        root.right = root.left;
        root.left = tmp;

        // 递归左子树 交换左右子节点
        mirrorTree(root.left);
        // 递归右子树 交换左右子节点
        mirrorTree(root.right);

        // 返回结果
        return root;
    }
}