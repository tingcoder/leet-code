package com.tingcoder.leetcode.linked_list;

import com.tingcoder.leetcode.base.ListNode;

/***
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author yfeng
 * @date 2019-01-10 16:30
 */
public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        DeleteDuplicates_83 dd = new DeleteDuplicates_83();

        ListNode one = new ListNode(1);
        ListNode two_1 = new ListNode(2);
        ListNode two_2 = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(4);
        one.next = two_1;
        two_1.next = two_2;
        two_2.next = three;
        three.next = four;

        System.out.println(one);
        one = dd.deleteDuplicates(one);
        System.out.println(one);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            ListNode nextNode = curNode.next;
            if (nextNode.val == curNode.val) {
                //重复元素消除
                if (nextNode.next == null) {
                    curNode.next = null;
                } else {
                    curNode.next = nextNode.next;
                }
            } else {
                //切换到下一个节点
                curNode = nextNode;
            }
        }
        return head;
    }
}
