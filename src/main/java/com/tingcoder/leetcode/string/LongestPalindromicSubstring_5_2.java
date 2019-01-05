package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 动态规划的解法
 */
public class LongestPalindromicSubstring_5_2 {
    public static void main(String[] args) {
        LongestPalindromicSubstring_5_2 lps = new LongestPalindromicSubstring_5_2();
        System.out.println(lps.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        int strLen = s.length();
        if (strLen < 2) {
            return s;
        }
        String result = "";
        boolean[][] dp = new boolean[strLen][strLen];
        for (int gap = 0; gap < strLen; gap++) {
            loop:
            for (int i = 0; i < strLen - 1; i++) {
                int j = i + gap;
                if (j >= strLen) {
                    break loop;
                }
                boolean sameChar = s.charAt(i) == s.charAt(j);
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = sameChar;
                } else {
                    dp[i][j] = sameChar && dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

}
