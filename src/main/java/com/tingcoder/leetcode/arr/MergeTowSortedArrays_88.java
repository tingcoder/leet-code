package com.tingcoder.leetcode.arr;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeTowSortedArrays_88 {
    public static void main(String[] args) {
        MergeTowSortedArrays_88 mtsa = new MergeTowSortedArrays_88();
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        mtsa.merge(nums1, 5, nums2, 1);
        System.out.println(JSON.toJSONString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        if (n <= 0) {
            return;
        }
        for (int i = m + n - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }
        int idx1 = n;
        int idx2 = 0;
        for (int i = 0; i < m + n; i++) {
            int val = 0;
            if (idx1 >= m + n) {
                val = nums2[idx2++];
            } else if (idx2 >= n) {
                val = nums1[idx1++];
            } else if (nums1[idx1] <= nums2[idx2]) {
                val = nums1[idx1++];
            } else {
                val = nums2[idx2++];
            }
            nums1[i] = val;
        }
    }
}
