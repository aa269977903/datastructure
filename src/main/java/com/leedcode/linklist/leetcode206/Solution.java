package com.leedcode.linklist.leetcode206;

/**
 * 反转链表
 * 1 -> 2 -> 3 -> null 变成  3 -> 2 -> 1 -> null
 * Created by cestlavie on 2019/7/8.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode now = null;

        while (head != null){
            if(now == null){
                now = new ListNode(head.val);
            }else {
                int tmp = now.val;
                ListNode listNode = new ListNode(head.val);
                listNode.next = now;
                now = listNode;
            }
            head = head.next;
        }
        return now;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(9);

        ListNode listNode = new Solution().reverseList(l1);
        System.out.println(listNode);
    }
}
