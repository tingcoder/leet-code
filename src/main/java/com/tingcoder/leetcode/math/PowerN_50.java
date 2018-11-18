package com.tingcoder.leetcode.math;

/**
 * https://leetcode-cn.com/problems/powx-n/description/
 */
public class PowerN_50 {
    public static void main(String[] args) {
        double d1 = 0;
        double d2 = 0;
        System.out.println(d1 == d2);
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1d / optimizePow(x, -((long) n));
        }

        if (n <= 4) {
            return simplePow(x, n);
        }

        return optimizePow(x, n);
    }

    public double simplePow(double x, long n) {
        double res = 1.0;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public double optimizePow(double x, long n) {
        if (n <= 4) {
            return simplePow(x, n);
        }
        long div = n / 4;
        long rest = n % 4;

        return optimizePow(optimizePow(x, div), 4) * simplePow(x, rest);
    }
}
