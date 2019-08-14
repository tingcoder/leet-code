package com.tingcoder.leetcode.two_pointer;

/**
 * Description.
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author shizhi
 * Created at 2019-06-05 20:11
 * @version com.tingcoder.leetcode.two_pointer.MaxArea_11 v0.1
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        int[] datas = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea_11 ma = new MaxArea_11();
        System.out.println(ma.maxArea(datas));
    }

    public int maxArea(int[] height) {
        if (height == null){
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int curArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
