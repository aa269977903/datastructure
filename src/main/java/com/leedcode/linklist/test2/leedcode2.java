package com.leedcode.linklist.test2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。 如果，我们将这两个数相加起来，则会返回一个新的链
 * 表来表示它们的和。 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class leedcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;

        //承载进位的数值
        int tmp = 0;

        while (l1 != null || l2 != null){
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;

            int total = x1 + x2 + tmp;
            //tmp取商
            tmp = total / 10;
            //结果取余
            total = total % 10;

            cur.next = new ListNode(total);
            cur = cur.next;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        if(tmp == 1){
            cur.next = new ListNode(tmp);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);

        ListNode listNode = new leedcode2().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
