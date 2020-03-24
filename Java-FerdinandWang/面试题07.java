/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题07 重建二叉树
 * 题目链接:https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历为空则直接返回null
        if(preorder == null || preorder.length == 0){
            return null;
        }
        //用HashMap保存中序遍历的节点值和数组序号
        Map<Integer, Integer> indexMap = new HashMap<Integer,Integer>();
        int length = preorder.length;
        for(int i = 0; i < length; i ++){
            indexMap.put(inorder[i],i);
        }
        //调用重建函数
        TreeNode root = reBuildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    /**
     * 以下是核心递归代码
     * 参数说明:
     * @preorder 前序遍历的数组
     * @preorderStart 前序遍历中该树的节点起始索引
     * @preorderEnd 前序遍历中该树的节点终止索引
     * @inorder 中序遍历的数组
     * @inorderStart 中序遍历中该树的节点起始索引
     * @inorderEnd 中序遍历中该树的节点终止索引
     * @indexMap 存储中序遍历的(inorder[i], i)节点值对应数组索引的map
     */
    public TreeNode reBuildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer,Integer> indexMap){
        //如果起始索引大于终止索引则递归结束
        if(preorderStart > preorderEnd){
            return null;
        }
        
        //根节点的值为前序遍历数组起始索引对应的值
        int rootVal = preorder[preorderStart];
        //创建根节点存储根节点的值
        TreeNode root = new TreeNode(rootVal);

        //如果起始索引和终止索引相等,则表示左子树和右子树为同一节点,即该节点为该子树的根节点
        if(preorderStart == preorderEnd){
            return root;
        }else{
            int rootIndex = indexMap.get(rootVal); //从map中获取根节点在中序遍历中的索引
            int leftNodes = rootIndex - inorderStart;   //左子树的节点数
            int rightNodes = inorderEnd - rootIndex;   //右子树的节点数

            //递归左子树
            TreeNode left = reBuildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            //递归右子树
            TreeNode right = reBuildTree(preorder, preorderStart + leftNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = left;
            root.right = right;
            return root;
        }
    }
}