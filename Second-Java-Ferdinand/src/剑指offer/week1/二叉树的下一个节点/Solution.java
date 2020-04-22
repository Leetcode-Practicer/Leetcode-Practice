package 剑指offer.week1.二叉树的下一个节点;
/**
 * 二叉树的下一个节点
 * 题目描述:
 *     给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点。
 * 注意：
 *     如果给定的节点是中序遍历序列的最后一个，则返回空节点;
 *     二叉树一定不为空，且给定的节点一定不是空节点；
 * 样例:
 *     假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。
 *     则应返回值等于3的节点。
 * 解释：该二叉树的结构如下，2的后继节点是3。
 *    2
 *   / \
 *  1   3
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;
    TreeNode(int x) { val = x; }
}
//解题思路:分情况讨论
public class Solution {
    public TreeNode inorderSuccessor(TreeNode p) {
        //1.如果该节点有右子树的话, 那么后继节点为右子树最左边的节点
        if (p.right != null){
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        }
        //2.如果该节点没有右子树,那么沿着父系节点找,
        //  直到father为空 或者 当前节点为父节点的左儿子,
        //  那么当前节点的父节点为所求后继节点
        while(p.father != null && p == p.father.right) p = p.father;
        return p.father;
    }
}
