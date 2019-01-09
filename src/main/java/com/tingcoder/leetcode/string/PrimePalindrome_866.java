package com.tingcoder.leetcode.string;

/***
 * @author yfeng
 * @date 2019-01-09 12:12
 *
 * https://leetcode-cn.com/problems/prime-palindrome/
 */
public class PrimePalindrome_866 {

    public static void main(String[] args) {
        PrimePalindrome_866 pp = new PrimePalindrome_866();
        System.out.println(pp.primePalindrome(8));
        System.out.println(pp.primePalindrome(11));
    }

    public int primePalindrome(int N) {
        if (N < 2) {
            return 2;
        }
        if (N <= 3) {
            return N;
        }
        int val = N;
        //将目标值调整为奇数
        if (val % 2 == 0) {
            val++;
        }
        while (!isPalindrome(val) || !isPrime(val)) {
            //判断下一个数字，因为偶数不可能为质数，此处直接跳到下一个奇数
            val += 2;
        }
        return val;
    }

    /**
     * 由于调用方的限制，此处入参v只可能是奇数
     *
     * @param v
     * @return
     */
    private boolean isPrime(int v) {
        int maxVal = (int) Math.sqrt(v) + 1;
        int seg = 3;
        while (seg < maxVal) {
            if (v % seg == 0) {
                return false;
            }
            //跳下一个奇数
            seg += 2;
        }
        return true;
    }

    private boolean isPalindrome(int v) {
        if (v < 10) {
            return true;
        }
        int reverseVal = v % 10;
        int rest = v / 10;
        while (rest > 0) {
            reverseVal = reverseVal * 10 + rest % 10;
            rest = rest / 10;
        }
        return reverseVal == v;
    }
}