/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题32-II 从上到下打印二叉树 II
 * 题目链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//本题的解题思路与前一题类似，同样利用队列的特性
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){   //如果根节点为空，则直接返回一个空的数组列表
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();    //辅助队列
        List<List<Integer>> res = new ArrayList<>();   //结果列表

        queue.add(root);//初始化，将根节点入队

        //队列为空时结束循环
        while(!queue.isEmpty()){
            List<Integer> tmpList = new ArrayList<Integer>();  //临时列表，存放每行的节点


            //这里的循环比较特殊，需要将i初始化为当前队列的长度，然后用减法操作
            //注意：这里不能用加法操作，因为 queue.size() 是不断变化的，所以不能用常规的循环
            for(int i = queue.size(); i > 0; i--){
                TreeNode tmpNode = queue.poll();  //临时节点，队列弹出并返回该节点
                tmpList.add(tmpNode.val);      //将该节点加到临时列表中

                //判断临时节点的左右子节点是否为空，不为空则
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
            }
            //将临时列表加到结果列表里
            res.add(tmpList);
        }

        return res;
    }
}