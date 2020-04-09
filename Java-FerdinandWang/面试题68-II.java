/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题68-II 二叉树的最近公共祖先
 * 题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }

        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        boolean mid = (node == p || node == q);
        if(mid ? (left || right) : (left && right)){
            res = node;
        }
        return left||right||mid;
    }
}