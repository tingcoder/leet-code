package com.tingcoder.leetcode.dp;

/**
 * Description.
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * https://leetcode-cn.com/problems/count-and-say/
 * @author shizhi
 * Created at 2019-06-02 18:21
 * @version com.tingcoder.leetcode.dp.CountAndSay_38 v0.1
 */
public class CountAndSay_38 {

    public static void main(String[] args) {
        CountAndSay_38 cs = new CountAndSay_38();
        for (int i = 1; i <= 30; i++) {
            cs.testNum(i);
        }
    }

    private void testNum(int n) {
        System.out.println(n + "  ->  " + countAndSay(n));
    }

    public String countAndSay(int n) {
        String[] dp = new String[n < 3 ? 3 : n + 1];
        dp[1] = "1";
        dp[2] = "11";
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                dp[i] = caculateCountNum(dp[i - 1]);
            }
        }
        return dp[n];
    }

    private String caculateCountNum(String preVal) {
        StringBuilder buf = new StringBuilder();
        int pos = 0;
        int len = preVal.length();

        char curChar = preVal.charAt(pos++);
        int count = 1;

        while (pos < len) {
            char posChar = preVal.charAt(pos++);
            if (posChar == curChar) {
                count++;
            } else {
                buf.append(count).append(curChar);
                curChar = posChar;
                count = 1;
            }
        }
        buf.append(count).append(curChar);
        return buf.toString();
    }

}