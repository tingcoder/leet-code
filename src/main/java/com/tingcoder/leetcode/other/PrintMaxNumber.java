package com.tingcoder.leetcode.other;

/***
 题目：
 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。

 第一思路：
 首先计算出n位数的最大十进制数，然后利用循环输出从1到最大的n位数。(未考虑数字溢出的情况，使用int或long都有问题)

 于是有了本段代码实现
 * @author yfeng
 * @date 2018-11-17 7:15
 */
public class PrintMaxNumber {
    /**
     * '0'这个字符的ASCII码
     */
    private char zero = 48;
    /**
     * '9'这个字符的ASCII码
     */
    private char nine = 57;

    public static void main(String[] args) {
        PrintMaxNumber pn = new PrintMaxNumber();
        pn.printMaxNum(6);
    }

    public void printMaxNum(int n) {
        if (n <= 0) {
            return;
        }

        char[] numChars = new char[n + 1];
        for (int i = 0; i <= n; i++) {
            numChars[i] = zero;
        }

        while (true) {
            increment(numChars);
            //当第一位为1即任务结束
            if (numChars[0] > zero) {
                break;
            }
            printCurNum(numChars);
        }
    }

    private void increment(char[] numChars) {
        int incIdx = numChars.length - 1;
        while (true) {
            //低位自增
            numChars[incIdx]++;

            //若低位自增大于9，即需要本位清零并进位了
            if (numChars[incIdx] > nine) {
                numChars[incIdx] = zero;
                incIdx--;
            } else {
                //本次自增无需进位了
                break;
            }
        }
    }

    /**
     * 打印当前这个数值
     *
     * @param numChars
     */
    private void printCurNum(char[] numChars) {
        /**
         * 注意此数字得从前开始打印
         */
        int len = numChars.length;
        boolean printing = false;
        for (int i = 1; i < len; i++) {
            char curChar = numChars[i];
            if (!printing && curChar > zero) {
                printing = true;
            }
            if (printing) {
                System.out.print(curChar);
            }
        }
        System.out.println();
    }
}