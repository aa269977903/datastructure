package com.leedcode.linklist.leetcode21;

/**
 * Created by Administrator on 2019/7/5.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(val + "->");
        while(next !=null){
            res.append(next.val + "->");
            next = next.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
