package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome_680 {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String val = s.trim();
        if ("".equals(val)) {
            return true;
        }
        return isValidatePalindrome(val, true);
    }

    public boolean isValidatePalindrome(String str, boolean canDel) {
        int len = str.length();
        int leftIdx = 0;
        int rightIdx = len - 1;
        while (leftIdx <= rightIdx) {
            char leftChar = str.charAt(leftIdx);
            char rightChar = str.charAt(rightIdx);
            if (leftChar != rightChar) {
                if (canDel) {
                    return isValidatePalindrome(str.substring(leftIdx, rightIdx), false)
                            || isValidatePalindrome(str.substring(leftIdx + 1, rightIdx + 1), false);
                } else {
                    return false;
                }
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_680 vp = new ValidPalindrome_680();
        System.out.println(vp.validPalindrome("aba"));
        System.out.println(vp.validPalindrome("abca"));
    }
}
