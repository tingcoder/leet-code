package com.tingcoder.leetcode.arr;

import com.alibaba.fastjson.JSON;

/**
 * Description.
 *
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author shizhi
 * Created at 2019-08-13 20:11
 * @version com.tingcoder.leetcode.arr.FirstMissingPositive_41 v0.1
 */
public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        FirstMissingPositive_41 fmp = new FirstMissingPositive_41();
        System.out.println(fmp.firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(fmp.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(fmp.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
        System.out.println(fmp.firstMissingPositive(new int[] {2, 1}));
        System.out.println(fmp.firstMissingPositive(new int[] {2, 2}));
        System.out.println(fmp.firstMissingPositive(new int[] {3, 4, 1, -1}));
        System.out.println(fmp.firstMissingPositive(new int[] {11, 1, 6, 11, 5, 5, -6, 9, -3, 9, 5, 4, 2, -8, 16, -6, -4, 2, 3}));
    }

    private void swap(int[] nums, int i, int j) {
        int iVal = nums[i];
        nums[i] = nums[j];
        nums[j] = iVal;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int len = nums.length;
        int maxVal = len;
        int idx = 0;
        while (idx < len) {
            int curVal = nums[idx];
            if (curVal <= 0 || curVal > maxVal) {
                idx++;
                continue;
            }
            if (curVal >= idx + 1) {
                idx++;
                continue;
            }
            if (nums[idx] == nums[curVal - 1]) {
                idx++;
                continue;
            }
            swap(nums, idx, curVal - 1);
        }

        for (int i = 0; i < len; i++) {
            int curVal = nums[i];
            if (curVal != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
