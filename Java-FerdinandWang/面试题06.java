/** 
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题06 从尾到头打印链表
 * 题目链接:https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 
 * 题目思路:利用栈,将元素全部压入栈,然后依次弹出即可
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;

        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();

        int[] res = new int[size];

        for(int i=0; i<size; i++){
            res[i] = stack.pop().val;
        }
        return res;
    }
}