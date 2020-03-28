/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题18 删除链表的节点
 * 题目链接:https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 
 * 本题的主要思路是双指针法删除链表节点
 * java有垃圾回收机制,不需要手动free
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){  //链表是空链表直接返回null
            return null;
        }

        //链表的第一个节点值就是val 则使头结点的下一个节点为头结点(即删除头结点)
        if(head.val == val){ 
            head = head.next;
            return head;
        }

        ListNode p = head.next;  //初始化p指向头结点的下一个节点
        ListNode q = head;  //初始化q指向头结点
        
        while(p != null){   //p指向为空则结束
            if(p.val == val){     
                q.next = p.next;  //删除p指向的节点
                break;      //结束循环
            }
            q = q.next;   //移动q指针
            p = p.next;   //移动p指针
        }

        return head;
    }
}