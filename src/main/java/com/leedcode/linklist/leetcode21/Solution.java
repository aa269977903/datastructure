package com.leedcode.linklist.leetcode21;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
   输出：1->1->2->3->4->4
 * Created by cestlavie on 2019/7/8.
 */
public class Solution {

    /**
     * 递归解法
     * 1 如果l1为空 则返回l2
     * 2 如果l2为空 则返回l1
     * 3 如果l1.val < l2.val  list1[0]+merge(list1[1:],list2)
     * 4 反之 list2[0]+merge(list1,list2[1:])
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);

        ListNode listNode = new Solution().mergeTwoLists(l1, l2);

        System.out.println(listNode);
    }
}
