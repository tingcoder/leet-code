package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String val = s.trim();
        if ("".equals(val)) {
            return true;
        }
        int len = val.length();
        int leftIdx = 0;
        int rgithIdx = len - 1;

        while (leftIdx <= rgithIdx) {
            char curLeftChar = toComparableChar(val.charAt(leftIdx));
            if (!isValidChar(curLeftChar)) {
                leftIdx++;
                continue;
            }
            char rightChar = toComparableChar(val.charAt(rgithIdx));
            if (!isValidChar(rightChar)) {
                rgithIdx--;
                continue;
            }
            if (curLeftChar != rightChar) {
                return false;
            }
            leftIdx++;
            rgithIdx--;
        }
        return true;
    }

    public char toComparableChar(char charVal) {
        if (charVal >= 'A' && charVal <= 'Z') {
            int lowerChar = (int) 'a' + ((int) charVal - (int) 'A');
            return (char) lowerChar;
        }
        return charVal;
    }

    public boolean isValidChar(char charVal) {
        if (charVal >= '0' && charVal <= '9') {
            return true;
        }
        if (charVal >= 'a' && charVal <= 'z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 vp = new ValidPalindrome_125();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("race a car"));
        System.out.println(vp.isPalindrome(""));
    }
}
