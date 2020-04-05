/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题54 二叉搜索树的第K大节点
 * 题目链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//本题目的主要思路是用深度优先搜索，用右、根、左的方式遍历二叉搜索树
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    // k不断的-- 减到0的前一次 所遍历到的节点即为所求
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}