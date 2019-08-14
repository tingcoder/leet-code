package com.tingcoder.leetcode.two_pointer;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Description.
 *
 * @author shizhi
 * Created at 2019-06-05 23:46
 * @version com.tingcoder.leetcode.two_pointer.TwoNumSum_1 v0.1
 */
public class TwoNumSum_1 {
    public static void main(String[] args) {
        TwoNumSum_1 tns = new TwoNumSum_1();
        int[] res = tns.twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println(JSON.toJSONString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            map.put(target - curVal, i);
        }

        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            Integer restIndex = map.get(curVal);
            if (restIndex != null && restIndex.intValue() != i) {
                return new int[] {i, restIndex};
            }
        }
        return new int[] {};
    }
}
