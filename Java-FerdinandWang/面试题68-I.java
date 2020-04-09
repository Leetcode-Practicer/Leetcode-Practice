/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题68-I 二叉搜索树的最近公共祖先
 * 题目链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 
 * 解题思路:
 * 一共有以下五种情况
 * 1.二叉树本身为空，root == null ，return root
 * 2.p.val == q.val ,一个节点也可以是它自己的祖先
 * 3.p.val 和 q.val 都小于 root.val
 *    (两个子节点的值都小于根节点的值，说明它们的公共节点只能在二叉树的左子树寻找）
 * 4.p.val 和 q.val 都大于 root.val
 *    (两个子节点的值都大于根节点的值，说明它们的公共节点只能在二叉树的右子树寻找）
 * 5.如果上述的情况皆不满足，说明其公共节点既不在左子树也不在右子树上，只能为最顶端的公共节点，return root
 *   p.val < root.val && q.val > root.val 或 p.val > root.val && q.val < root.val
 * -----------------------------------------------------------------------------------------------------
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}