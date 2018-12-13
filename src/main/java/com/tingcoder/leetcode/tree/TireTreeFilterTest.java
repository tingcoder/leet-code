package com.tingcoder.leetcode.tree;

import com.google.common.collect.Sets;
import com.google.common.io.Files;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

/***
 * @author yfeng
 * @date 2018-12-10 16:01
 */
public class TireTreeFilterTest {
    private static boolean isBlank(String input) {
        return input == null || "".equals(input.trim());
    }

    public static void main(String[] argv) throws Exception {
        TireTreeFilter filter = new TireTreeFilter();
        String unSafeWordsPath = "D:\\software\\mgck_102318\\mgck2017\\key.txt";
        String testFilePath = "D:\\software\\mgck_102318\\mgck2017\\测试材料.txt";

        String content = Files.toString(new File(unSafeWordsPath), Charset.forName("UTF-8"));
        String[] words = content.split("\\|");

        Set<String> sets = Sets.newHashSet(words);
        int count = 0;
        long start = System.currentTimeMillis();
        for (String word : sets) {
            if (isBlank(word)) {
                continue;
            }
            filter.addWord(word);
            count++;
        }
        long spend = System.currentTimeMillis() - start;
        System.out.println("构建TireTree消耗时间 " + spend + "ms  敏感词数量：" + count);
        String targetContent = Files.toString(new File(testFilePath), Charset.forName("UTF-8"));

        start = System.currentTimeMillis();
        String saveVal = filter.filter(targetContent, "***");
        spend = System.currentTimeMillis() - start;
        System.out.println("校验文本大小:" + targetContent.length());
        System.out.println("==============================");
        System.out.println(saveVal);
        System.out.println("==============================");
        System.out.print("消耗时间 " + spend + "ms");
    }
}
