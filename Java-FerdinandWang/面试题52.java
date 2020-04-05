/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题52 两个链表的第一个公共节点
 * 题目链接:https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //只要有一个链表为空，则不存在相同节点
        if(headA == null || headB == null){
            return null;
        }

        // node1初始化指向headA
        // node2初始化指向headB
        ListNode node1 = headA;
        ListNode node2 = headB;

        //只要node1 != node2 就继续循环
        while(node1 != node2){
            //node1遍历完headA之后，再指向headB的头结点，遍历headB
            node1 = (node1 == null) ? headB : node1.next;
            //node2遍历完headB之后，再指向headA的头结点，遍历headA
            node2 = (node2 == null) ? headA : node2.next;
            //此时如果找到了 重复节点，则跳出循环
            //如果一直找不到重复节点，那么两个指针会同时指向null,也会跳出循环，此时返回的node1是null
        }

        return node1;

    }
}