package com.tingcoder.leetcode.util;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

/***
 * @author yfeng
 * @date 2019-01-16 15:10
 */
public class FileFilterTool {

    public static void main(String[] args) {
        List<String> exeludes = Lists.newArrayList();

        List<String> includes = Lists.newArrayList(
                "DailyRollingFileAppender");
        filterFile("D://start.log", "D://start-result.log", exeludes, includes);
    }

    public static void filterFile(String srcFile, String targetFile, List<String> excludes, List<String> includes) {

        try {
            Scanner scanner = new Scanner(new File(srcFile));
            FileWriter writer = new FileWriter(new File(targetFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                boolean containtsExclude = false;
                boolean containtsInclude = false;

                if (!excludes.isEmpty()) {
                    checkContaints:
                    for (String filter : excludes) {
                        if (line.contains(filter)) {
                            containtsExclude = true;
                            break checkContaints;
                        }
                    }
                }
                if (!includes.isEmpty()) {
                    checkInclude:
                    for (String filter : includes) {
                        if (line.contains(filter)) {
                            containtsInclude = true;
                            break checkInclude;
                        }
                    }
                } else {
                    containtsInclude = true;
                }

                if (!containtsExclude && containtsInclude) {
                    writer.append(line).append("\n");
                }
            }
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
