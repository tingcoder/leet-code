package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 递归的解法
 */
public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        LongestPalindromicSubstring_5 lps = new LongestPalindromicSubstring_5();
        System.out.println(lps.longestPalindrome("aaaa"));
    }

    class Result {
        int sIdx = 0;
        int eIdx = 0;
        int maxLen = 0;
        int minMargin = 0;

        public void resetIdx(int sIdx, int eIdx) {
            int curLen = eIdx - sIdx + 1;
            if (curLen <= this.maxLen) {
                return;
            }
            this.sIdx = sIdx;
            this.eIdx = eIdx;
            this.maxLen = curLen;
            this.minMargin = (this.maxLen + 1) / 2;
        }
    }

    private void expandSubseq(String s, Result result, int curSIdx, int curEIdx) {
        if ((curSIdx < 0 || curEIdx >= s.length())) {
            return;
        }
        if (curSIdx != curEIdx && s.charAt(curSIdx) != s.charAt(curEIdx)) {
            return;
        }
        result.resetIdx(curSIdx--, curEIdx++);
        while (curSIdx >= 0 && curEIdx < s.length()) {
            if (s.charAt(curSIdx) != s.charAt(curEIdx)) {
                return;
            }
            result.resetIdx(curSIdx--, curEIdx++);
        }
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }

        Result result = new Result();
        for (int i = 0; i < s.length(); i++) {
            expandSubseq(s, result, i, i);
            expandSubseq(s, result, i, i + 1);
        }

        return s.substring(result.sIdx, result.eIdx + 1);
    }
}
