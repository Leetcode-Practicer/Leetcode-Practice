package 剑指offer.week1.从尾到头打印链表;

/**
 * 反转链表
 * 样例:
 *     输入：[2, 3, 5]
 *     返回：[5, 3, 2]
 */
public class Solution {
    static ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p = null;
        ListNode q = null;
        ListNode cur = head;
        while (cur != null){
            q = cur.next;
            cur.next = p;
            p = cur;
            cur = q;
        }
        return p;
    }
// test
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = reverseList(node1);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
//链表结构
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
};