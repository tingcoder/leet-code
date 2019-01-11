package com.tingcoder.leetcode.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author yfeng
 * @date 2019-01-11 9:49
 */
public class PalindromePartition_131 {

    public static void main(String[] args) {
        PalindromePartition_131 pp = new PalindromePartition_131();
        List<List<String>> results = pp.partition("aabcdcbf");
        for (List<String> curList : results) {
            System.out.println(JSON.toJSONString(curList));
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        if (s == null) {
            return results;
        }
        int len = s.trim().length();
        if (len == 0) {
            return results;
        }
        boolean[][] dp = new boolean[len][len];
        List<String> curList = new ArrayList<String>();
        partitionDFS(s, 0, curList, results, dp);

        return results;
    }

    private void partitionDFS(String txt, int curIdx, List<String> curList, List<List<String>> results, boolean[][] dp) {
        int len = txt.length();
        if (curIdx == len) {
            results.add(new ArrayList<String>(curList));
            return;
        }

        for (int i = curIdx; i < len; i++) {
            if (isPalindrome(txt, curIdx, i, dp)) {
                curList.add(txt.substring(curIdx, i + 1));
                partitionDFS(txt, curIdx + 1, curList, results, dp);
              //  curList.remove(curList.size() - 1);
            }
        }
    }

    /**
     * 判断字符串是否为回文字符串
     *
     * @param val
     * @return
     */
    private boolean isPalindrome(String val, int startIdx, int endIdx, boolean[][] dp) {
        boolean palindrome;
        if (startIdx == endIdx) {
            palindrome = true;
        } else if (startIdx + 1 == endIdx) {
            palindrome = val.charAt(startIdx) == val.charAt(endIdx);
        } else {
            palindrome = dp[startIdx + 1][endIdx - 1] && val.charAt(startIdx) == val.charAt(endIdx);
        }
        dp[startIdx][endIdx] = palindrome;
        return palindrome;
    }
}