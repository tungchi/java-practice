package com.ykfa.leetcode.question.q206;

/**
 * @author yingkefa
 * @date 2020年03月02日11:04:37
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void addNext(ListNode listNode) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = listNode;
    }

    @Override
    public String toString() {
        return val + "->";
    }
}
