package com.tingcoder.leetcode.string;

/***
 * @author yfeng
 * @date 2019-03-15 16:47
 */
public class RemoveRemainOnce {

    public static void main(String[] args) {

        String str = "aaaabbbddeee";
        int len = str.length();
        char[] buffer = new char[5];
        char cur = str.charAt(0);
        buffer[0] = cur;
        int counter = 1;
        for (int pos = 1; pos < len; pos++) {
            char c = str.charAt(pos);
            if (counter >= buffer.length) {
                System.out.print(new String(buffer));
                buffer = new char[5];
                counter = 0;
            }
            if (c != cur) {
                buffer[counter] = c;
                cur = c;
                counter++;
            }
        }
        System.out.println(new String(buffer));

        testMy();
    }

    public static void testMy() {
        RemoveRemainOnce rro = new RemoveRemainOnce();
        String input = "abcdxxxandxxxandxyxz";
        String remove = "boy";
        System.out.println("input : " + input);
        System.out.println("output : " + rro.removeRemainOnce_2(input));
    }

    public String removeRemainOnce_2(String input) {
        StringBuilder buff = new StringBuilder();
        char curChar = input.charAt(0);
        buff.append(curChar);
        for (int i = 1; i < input.length(); i++) {
            char charVal = input.charAt(i);
            if (charVal != curChar) {
                buff.append(charVal);
                curChar = charVal;
            }
        }
        return buff.toString();
    }

    public String removeRemainOnce(String input, String removeStr) {
        StringBuilder buff = new StringBuilder();
        StringBuilder wordBuff = new StringBuilder();
        boolean findFirst = false;
        int chekLen = removeStr.length();
        int chkIdx = 0;

        for (char charVal : input.toCharArray()) {
            if (charVal == removeStr.charAt(chkIdx)) {
                wordBuff.append(charVal);
                chkIdx++;
                if (chkIdx == chekLen) {
                    if (!findFirst) {
                        buff.append(wordBuff);
                        findFirst = true;
                    }
                    chkIdx = 0;
                    wordBuff = new StringBuilder();
                }
            } else {
                buff.append(wordBuff).append(charVal);
                chkIdx = 0;
                wordBuff = new StringBuilder();
            }
        }
        return buff.toString();
    }
}
