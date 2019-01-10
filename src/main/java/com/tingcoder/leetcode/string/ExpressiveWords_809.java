package com.tingcoder.leetcode.string;

/**
 * https://leetcode-cn.com/problems/expressive-words/
 */
public class ExpressiveWords_809 {
    public static void main(String[] args) {
        ExpressiveWords_809 ew = new ExpressiveWords_809();
        System.out.println(ew.isMatch("hellllo", "hllo"));
    }

    private static class CharIter {
        Character curChar;
        int idx;
        int count;

        public CharIter(Character expChar, int idx) {
            this.curChar = expChar;
            this.idx = idx;
            this.count = 1;
        }
    }

    private boolean isBlank(String val) {
        return val == null || "".equals(val.trim());
    }

    public int expressiveWords(String S, String[] words) {
        if (isBlank(S)) {
            return 0;
        }
        if (words == null || words.length == 0) {
            return 0;
        }
        int count = 0;

        for (String word : words) {
            if (isMatch(S, word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatch(String exp, String word) {
        int expLen = exp.length();
        int wordLen = word.length();
        if (wordLen >= expLen) {
            return false;
        }
        int expIdx = 0;
        int wordIdx = 0;
        while (expIdx < expLen && wordIdx < wordLen) {
            CharIter expIter = getCharIter(exp, expIdx);
            expIdx = expIter.idx + 1;

            CharIter wordIter = getCharIter(word, wordIdx);
            wordIdx = wordIter.idx + 1;

            if (!expIter.curChar.equals(wordIter.curChar)) {
                return false;
            }

            if (expIter.count < 3 && expIter.count != wordIter.count) {
                return false;
            }
        }

        if (expIdx < expLen || wordIdx < wordLen) {
            return false;
        }
        return true;
    }


    private CharIter getCharIter(String txt, int idx) {
        Character expChar = txt.charAt(idx);
        CharIter iter = new CharIter(expChar, idx);
        while (true && iter.idx < txt.length() - 1) {
            Character curChar = txt.charAt(iter.idx + 1);
            if (curChar.equals(expChar)) {
                iter.count++;
                iter.idx++;
            } else {
                break;
            }
        }
        return iter;
    }
}