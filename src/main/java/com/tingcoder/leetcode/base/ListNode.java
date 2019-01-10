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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        builder.append("->");
        if (next == null) {
            builder.append("null");
        } else {
            builder.append(next.toString());
        }
        return builder.toString();
    }
}