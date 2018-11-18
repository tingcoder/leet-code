package com.tingcoder.leetcode.math;

/**
 * https://leetcode-cn.com/problems/sqrtx/description/
 * <p>
 * 二分查找法
 */
public class Sqrt_69 {

    int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        if (x < 4) {
            return 1;
        }

        int left = 0;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int div = x / mid;
            if (div == mid) {
                return mid;
            } else if (div > mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }
}