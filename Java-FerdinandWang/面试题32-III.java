/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题32-III 从上到下打印二叉树III
 * 题目链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
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

//本题的主要思路与前一题类似
//但是巧妙的地方在于利用结果列表的size来判断当前是奇数行还是偶数行

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){  //如果根节点为空,则直接返回一个空列表
            return new ArrayList<>();
        }
        
        //结果列表
        List<List<Integer>> res = new ArrayList<>();
        //辅助队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        //初始化,将根节点入队
        queue.add(root);

        //队列为空,则循环结束
        while(!queue.isEmpty()){

            //临时列表,存放当前行的所有节点值
            List<Integer> tmpList = new ArrayList<>();
            
            for(int i = queue.size(); i > 0; i--){
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
                
            }
            
            //对结果列表的size进行2取余操作,如果余数是0则为奇数行,如果余数是1则为偶数行,偶数行需要将临时列表翻转
            if(res.size() % 2 == 1){
                Collections.reverse(tmpList);
            }

            //将临时列表加入结果列表
            res.add(tmpList);
            
        }

        return res;
    }
}