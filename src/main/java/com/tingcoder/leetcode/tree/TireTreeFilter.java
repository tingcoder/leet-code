package com.tingcoder.leetcode.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于字典树的敏感词过滤器
 */
public class TireTreeFilter {
    private TireNode root = new TireNode();

    private static class TireNode {
        @Getter
        @Setter
        private boolean end;

        private Map<Character, TireNode> children = new HashMap();

        public TireNode getSubNode(Character character) {
            return children.get(character);
        }

        public void addSubNode(Character charVal, TireNode node) {
            children.put(charVal, node);
        }
    }

    private boolean isBlank(String input) {
        return input == null || "".equals(input.trim());
    }

    public void addWord(String word) {
        if (isBlank(word)) {
            return;
        }
        String wordVal = word.trim();
        int len = wordVal.length();
        TireNode curTireNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = wordVal.charAt(i);
            TireNode childNode = curTireNode.getSubNode(curChar);
            if (childNode == null) {
                childNode = new TireNode();
                curTireNode.addSubNode(curChar, childNode);
            }
            curTireNode = childNode;
            if (i == len - 1) {
                curTireNode.setEnd(true);
            }
        }
    }

    public String filter(String inputText, String saveWord) {
        if (isBlank(inputText)) {
            return inputText;
        }

        String inputVal = inputText.trim();
        StringBuilder builder = new StringBuilder();

        int len = inputVal.length();
        int pos = 0;
        int idx = 0;
        TireNode curNode = root;
        while (pos < len) {
            Character curChar = inputVal.charAt(pos);
            curNode = curNode.getSubNode(curChar);
            if (curNode == null) {
                builder.append(inputVal.charAt(idx));
                idx++;
                pos = idx;
                curNode = root;
            } else if (curNode.isEnd()) {
                builder.append(saveWord);
                pos++;
                idx = pos;
                curNode = root;
            } else {
                pos++;
            }
        }
        builder.append(inputVal.substring(idx));

        return builder.toString();
    }

    public static void main(String[] argv) {
        TireTreeFilter s = new TireTreeFilter();
        s.addWord("共产");
        s.addWord("共同");
        s.addWord("家庭");
        s.addWord("家人");
        System.out.println(s.root);
        System.out.print(s.filter("k共产党lsO(∩_∩)Odjflk共产j", "敏感词"));
    }


}
