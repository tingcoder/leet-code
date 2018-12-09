package com.tingcoder.leetcode.base;

import lombok.Getter;

public class ListNode {
    @Getter
    public int val;
    @Getter
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
}