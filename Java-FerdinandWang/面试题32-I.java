/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题32-I 从上到下打印二叉树
 * 题目链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
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

//本题的主要思路是利用队列存储左右子树的节点
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) {   //根节点为空，则直接返回null
            return new int[0];
        }

        //创建链表队列
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化，将根节点添加到队列中
        queue.add(root);
        //列表存储结果，最后树妖转化成整形数组
        List<Integer> ans = new ArrayList<Integer>();

        //如果队列不为空就一直循环
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();   //弹出队列中的节点，并接收该节点
            ans.add(node.val);   //将节点的值加入结果列表

            //判断该节点的左右子节点是否为空，如果不为空就按照从左到右加入到队列中
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }


        //转化成整形数组返回结果
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}