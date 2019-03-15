package com.tingcoder.leetcode.string;

/***
 * @author yfeng
 * @date 2019-02-28 9:16
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 ll = new LengthOfLongestSubstring_3();
        System.out.println(ll.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ll.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ll.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ll.lengthOfLongestSubstring("dvdf"));
        System.out.println(ll.lengthOfLongestSubstring("tmmxt"));
    }

    private boolean charExists(boolean[] maps, char charVal) {
        return maps[(int) charVal];
    }

    private void markCharExists(boolean[] maps, char charVal, boolean exists) {
        maps[(int) charVal] = exists;
    }

    public int lengthOfLongestSubstring(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int n = input.length();
        if (n < 2) {
            return n;
        }
        int[] record = new int[128];
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            char cur = input.charAt(right);
            if (record[cur] > left) {
                left = record[cur];
            }
            record[cur] = right + 1;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring_2(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        boolean[] map = new boolean[128];
        int maxLen = 1;
        int startIdx = 0;
        int endIdx = 0;
        int strLen = input.length();

        char endChar = input.charAt(0);
        markCharExists(map, endChar, true);
        boolean rightPointer = true;
        while (true) {
            //右侧指针右侧滑动
            if (rightPointer) {
                endIdx++;
                //达到超出字符串结尾，直接退出
                if (endIdx == strLen) {
                    break;
                }
                endChar = input.charAt(endIdx);
                if (charExists(map, endChar)) {
                    //调整方向,左侧右移
                    rightPointer = false;
                    continue;
                } else {
                    //打标记
                    markCharExists(map, endChar, true);
                    int curLen = endIdx - startIdx + 1;
                    if (maxLen < curLen) {
                        maxLen = curLen;
                    }
                }
            } else {
                if (input.charAt(startIdx) == endChar || startIdx + 1 == endIdx) {
                    startIdx++;
                    rightPointer = true;
                    continue;
                }
                char curChar = input.charAt(startIdx);
                //右侧滑动，标记不在当前表格中
                markCharExists(map, curChar, false);
                startIdx++;
            }
        }
        return maxLen;
    }
}
