/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题24 反转链表
 * 题目链接:https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){  //链表为空,则直接返回null
            return null;
        }

        ListNode pre = null;  //上一个节点指针
        ListNode cur = head;  //当前节点指针
        ListNode aft = null;  //下一个节点指针

        while(cur != null){   //当前节点为空则终止循环
            aft = cur.next;    //下一个节点为当前指针的下一个节点
            cur.next = pre;   //当前节点的下一个节点指向上一个节点
            pre = cur;    //上一个节点指针向后移动
            cur = aft;    //当前节点指针向后移动
        }
        
        return pre;
    }
}