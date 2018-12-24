package com.tingcoder.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String input) {
        if (input == null) {
            return 0;
        }
        input = input.trim();
        Set<Character> charSet = new HashSet();

        for (int i = 0; i < input.length(); i++) {
            Character curChar = input.charAt(i);
            if (charSet.contains(curChar)) {
                charSet.remove(curChar);
            } else {
                charSet.add(curChar);
            }
        }
        if (charSet.isEmpty()) {
            return input.length();
        }
        return input.length() - charSet.size() + 1;
    }

    public int longestPalindrome_01(String input) {
        if (input == null) {
            return 0;
        }
        String val = input.trim();
        if (val.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charCountMap = new HashMap();

        for (int i = 0; i < val.length(); i++) {
            Character curChar = val.charAt(i);
            Integer count = charCountMap.get(curChar);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            charCountMap.put(curChar, count);
        }

        boolean plusOne = false;
        Integer count = 0;
        for (Integer itemCount : charCountMap.values()) {
            int curCount = (itemCount >> 1) << 1;
            if (itemCount % 2 == 1) {
                plusOne = true;
            }
            count += curCount;
        }
        return plusOne ? count + 1 : count;
    }
}