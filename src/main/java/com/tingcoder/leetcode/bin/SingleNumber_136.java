package com.tingcoder.leetcode.bin;
/***
 * 题目描述: https://leetcode-cn.com/problems/single-number/description/
 * @author yfeng
 * @date 2018-11-17 7:11
 */
public class SingleNumber_136 {

    /**
     * 利用异或运算符的两个特性：1. 顺序无关 2. 相同位两次叠加会消除
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
