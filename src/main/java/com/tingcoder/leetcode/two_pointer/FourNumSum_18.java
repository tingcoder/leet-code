package com.tingcoder.leetcode.two_pointer;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description.
 * https://leetcode-cn.com/problems/4sum/
 * @author shizhi
 * Created at 2019-06-05 22:46
 * @version com.tingcoder.leetcode.two_pointer.FourNumSum_18 v0.1
 */
public class FourNumSum_18 {

    public static void main(String[] args) {
        int[] data = {1, 0, -1, 0, -2, 2};
        FourNumSum_18 fns = new FourNumSum_18();
        List<List<Integer>> res = fns.fourSum(data, 0);
        for (List<Integer> row : res) {
            for (Integer item : row) {
                System.out.print(item + " , ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i1 = 0;
        int i4 = nums.length - 1;
        while (i1 <= i4 - 3) {
            int i2 = i1 + 1;
            int i3 = i4 - 1;
            int i1i4Sum = nums[i1] + nums[i4];
            int rest = target - i1i4Sum;
            while (i2 < i3) {
                if (nums[i2] + nums[i3] == rest) {
                    Integer[] curResult = {nums[i1], nums[i2], nums[i3], nums[i4]};
                    result.add(Arrays.asList(curResult));
                    i2++;
                    i3--;
                }
            }
        }
        return result;
    }
}