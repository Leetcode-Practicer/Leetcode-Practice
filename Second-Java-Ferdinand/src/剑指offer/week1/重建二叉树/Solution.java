package 剑指offer.week1.重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 题目描述:
 *     输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
 * 注意:
 *     二叉树中每个节点的值都互不相同；
 *     输入的前序遍历和中序遍历一定合法；
 * 样例:
 *     给定：
 *     前序遍历是：[3, 9, 20, 15, 7]
 *     中序遍历是：[9, 3, 15, 20, 7]
 *     返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
 *     返回的二叉树如下所示：
 *         3
 *        / \
 *       9  20
 *         /  \
 *        15   7
 */

//主要思想:递归
class Solution {
    //以便快速的找到索引对应的节点值
    static Map<Integer, Integer> map = new HashMap<>();
    static int [] preorder, inorder;

    public TreeNode buildTree(int[] _preorder, int[] _inorder) {
        preorder = _preorder;
        inorder = _inorder;
        //赋值<值, 索引>
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * dfs
     * @param pl 前序遍历左边界
     * @param pr 前序遍历右边界
     * @param il 中序遍历左边界
     * @param ir 中序遍历右边界
     * @return
     */
    static TreeNode dfs(int pl, int pr, int il, int ir){
        if(pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int k = map.get(root.val);
        //左子树的下标范围
        TreeNode left = dfs(pl + 1, pl + k - il, il, k - 1);
        //右子树的下标范围
        TreeNode right = dfs(pl + k - il +1, pr, k + 1 , ir);
        root.left = left;
        root.right = right;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}