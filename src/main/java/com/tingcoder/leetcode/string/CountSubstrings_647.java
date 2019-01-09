package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class CountSubstrings_647 {

    public static void main(String[] args) {
        CountSubstrings_647 cs = new CountSubstrings_647();
        System.out.println(cs.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0; i < s.length() - gap; i++) {
                int j = i + gap;
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}