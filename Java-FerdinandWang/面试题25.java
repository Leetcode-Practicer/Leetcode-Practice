/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题25 合并两个排序的链表
 * 题目链接:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //设置哨兵节点
        ListNode p = head;     //复制给工作指针P

        while(l1 != null && l2 != null){  //若两个链表中有一个遍历完,则循环结束
            if(l1.val < l2.val){     //将更小的节点赋值给工作指针的下一个节点,并移动更小节点的链表
                p.next = l1;           
                l1 = l1.next;     
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;   //移动工作指针
        }
        //循环结束,还若有多余节点,则全部赋值给p的下一个节点
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        //哨兵节点的下一个节点即为所求
        return head.next;
    }
}