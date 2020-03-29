/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题22 链表中的倒数第k个节点
 * 题目链接:https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//本题思路:双指针解法
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode first = head, second = head; //first为前置指针, second为后置指针

        //将first指针向前移动k次, 使first和second指针相距离k个节点
        for(int i = 0; i < k; i++){
            first = first.next;
        }

        //两个指针向前移动,直到前指针到null
        while(first != null){
            first = first.next;
            second = second.next;
        }
        // 此时second即为所求
        return second;
        

    }
}


 /**
  * 第二种解法,压栈,然后弹出取第k个,返回.
  * 这种解法空间复杂度是O(n) 
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> nodeStack = new Stack<ListNode>();
        ListNode p = head, q;
        
        while(p != null){
            nodeStack.push(p);
            p = p.next;
        }

        for(int i = 1; i <= k - 1; i++){
            nodeStack.pop();
        }
        q = nodeStack.pop();
        return q;
    }
}
  */
