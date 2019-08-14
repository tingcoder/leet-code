package com.tingcoder.leetcode.two_pointer;

import java.util.*;

/**
 * Description.
 * https://leetcode-cn.com/problems/3sum/
 * @author shizhi
 * Created at 2019-06-06 00:02
 * @version com.tingcoder.leetcode.two_pointer.ThreeNnumSum_15 v0.1
 */
public class ThreeNnumSum_15 {

    public static void main(String[] args) {
        int[] data = {-1, 0, 1, 2, -1, -4};
        //data = new int[] {0, 0, 0};
        ThreeNnumSum_15 fns = new ThreeNnumSum_15();
        List<List<Integer>> res = fns.threeSum(data);
        for (List<Integer> row : res) {
            for (Integer item : row) {
                System.out.print(item + " , ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);

        //减枝
        if (nums[0] > 0 || nums[len - 1] < 0) {
            return result;
        }

        Map<Integer, Integer> valueIdxMap = new HashMap();
        int idx = 0;
        for (Integer value : nums) {
            valueIdxMap.put(value, idx++);
        }

        Integer outVal = null;
        Integer innerVal = null;
        out:
        for (int i = 0; i <= len - 3; i++) {
            Integer curOut = nums[i];
            //减枝
            if (curOut > 0) {
                break out;
            }
            if (curOut.equals(outVal)) {
                continue out;
            }
            outVal = curOut;

            inner:
            for (int j = i + 1; j <= len - 2; j++) {
                Integer curInner = nums[j];
                if (curInner.equals(innerVal)) {
                    continue inner;
                }
                innerVal = curInner;
                if (outVal + innerVal > 0 || outVal + innerVal + nums[j + 1] > 0) {
                    continue out;
                }
                Integer restVal = -(outVal + innerVal);
                Integer restIdx = valueIdxMap.get(restVal);
                if (restIdx != null) {
                    if (restIdx > j) {
                        result.add(Arrays.asList(outVal, innerVal, restVal));
                    } else {
                        continue out;
                    }

                }
            }
        }

        return result;
    }
}
