package com.tingcoder.leetcode.linked_list;

import com.alibaba.fastjson.JSON;
import com.tingcoder.leetcode.base.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/description/
 */
public class RotateRight_61 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;

        RotateRight_61 rr = new RotateRight_61();
        ListNode newNode = rr.rotateRight(node1, 2000000000);
        System.out.println(JSON.toJSONString(newNode, true));
    }

    int listNodeSize(ListNode head) {
        int count = 1;
        ListNode iterNaode = head;
        while (iterNaode.next != null) {
            iterNaode = iterNaode.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        int size = listNodeSize(head);

        int skip = k % size;
        if (skip == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < skip; i++) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (null == slow.next) {
            return head;
        }
        //此时slow指向了新的tail
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}