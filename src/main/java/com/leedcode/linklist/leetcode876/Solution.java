package com.leedcode.linklist.leetcode876;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    如果有两个中间结点，则返回第二个中间结点。
    输入：[1,2,3,4,5,6]
    输出：此列表中的结点 4 (序列化形式：[4,5,6])
    由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();

        int num = 0;
        while (head != null){
            listNodes.add(head);
            head = head.next;
            num ++ ;
        }
        return listNodes.get(num/2);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode listNode = new Solution().middleNode(l1);
        System.out.println(listNode);
    }
}
