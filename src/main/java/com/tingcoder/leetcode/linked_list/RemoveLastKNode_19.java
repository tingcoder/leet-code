package com.tingcoder.leetcode.linked_list;

import com.tingcoder.leetcode.base.ListNode;

/**
 * 删除倒数第n个元素，那么我们定位到倒数N+1个元素，然后做删除
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class RemoveLastKNode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        if (n == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            // 当入参链表有N个元素的时候，要删除倒数第N个，也就是头节点的时候会
            // 出现fast == null
            if (head.next == null) {
                //只有一个节点时
                return null;
            } else {
                return head.next;
            }
        }

        //快慢指针一起向前走
        while (true) {
            //快指针走到末尾了
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow已经指向倒数第n+1个节点
        ListNode targetNode = slow.next.next;
        if (targetNode == null) {
            //说明slow指向了，倒数第二个，需要删除倒数第一个
            slow.next = null;
        } else {
            slow.next = targetNode;
        }
        return head;
    }
}
