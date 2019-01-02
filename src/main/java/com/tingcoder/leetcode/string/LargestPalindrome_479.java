package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/largest-palindrome-product/
 */
public class LargestPalindrome_479 {
    public static void main(String[] args) {
        LargestPalindrome_479 lp = new LargestPalindrome_479();
        System.out.println(lp.largestPalindrome(5));
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = max / 10;

        for (int i = max; i > min; i--) {
            long num = palindrome(i);
            for (long j = max; j * j > num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return 9;
    }

    public long palindrome(int val) {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        char[] charArray = Integer.toString(val).toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            builder.append(charArray[i]);
        }
        return Long.parseLong(builder.toString());
    }
}