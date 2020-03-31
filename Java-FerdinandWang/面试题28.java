/**
 *
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题28 对称的二叉树
 * 题目链接:https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  本题的解题思路是递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){   //如果根节点为空，则直接返回true
            return true;
        }
        
        // 传入判断函数，左子树和右子树
        return recur(root.left, root.right);
    }


    public boolean recur(TreeNode L, TreeNode R){
        //如果左节点和右节点同时到达null，则表示是对称的二叉树
        if(L == null && R == null){  
            return true;     
        }

        //如果有一个到达了null或者左节点的值和右节点不同，则返回false
        if(L == null || R == null || L.val != R.val){   
            return false;
        }

        //左子树的左节点==右子树的右节点，左子树的右节点==右子树的左节点   同时满足即为判定成功
        return recur(L.left, R.right) && recur(L.right, R.left);  

    }
}