package com.tingcoder.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author shizhi
 * Created at 2019-06-05 13:18
 * @version com.tingcoder.leetcode.string.StringConvert_6 v0.1
 */
public class StringConvert_6 {

    public static void main(String[] args) {
        StringConvert_6 sc = new StringConvert_6();
        sc.testConvert("LEETCODEISHIRING", 3);
        sc.testConvert("LEETCODEISHIRING", 4);
    }

    private void testConvert(String s, int numRows) {
        String result = convert(s, numRows);
        System.out.println(String.format("%s , %d -> %s", s, numRows, result));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> bufList = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            bufList.add(new StringBuilder());
        }
        char[] charArray = s.toCharArray();
        int bufIdx = 0;
        boolean addPos = true;
        for (char curChar : charArray) {
            bufList.get(bufIdx).append(curChar);
            if (addPos) {
                bufIdx++;
                if (bufIdx == numRows) {
                    bufIdx -= 2;
                    addPos = false;
                }
            } else {
                bufIdx--;
                if (bufIdx < 0) {
                    bufIdx += 2;
                    addPos = true;
                }
            }
        }
        StringBuilder buf = new StringBuilder();
        for (StringBuilder bufItem : bufList) {
            buf.append(bufItem);
        }
        return buf.toString();
    }
}
