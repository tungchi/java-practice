package com.ykfa.leetcode.question.q206;

/**
 * @author yingkefa
 * @date 2020年03月02日11:05:11
 */
public class Solution206 {

    public static void main(String[] args) {
        Solution206 solution = new Solution206();
        ListNode head = new ListNode(0);
        for (int i = 1; i < 6; i++) {
            head.addNext(new ListNode(i));
        }
        head = head.next;
        ListNode node = head;
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.print((Object) null);
        ListNode tail = solution.reverseList(head);
        node = tail;
        System.out.println();
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.print((Object) null);
    }

    public ListNode reverseList(ListNode head) {
        // 结果
        ListNode tail = null;
        // 待处理的
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;// 2345 345 45 5 null
            cur.next = tail;// 1 21 321 4321 54321
            tail = cur;// 1 21 321 4321 54321
            cur = next;// 2345 345 45 5 null
        }
        return tail;

    }

}
