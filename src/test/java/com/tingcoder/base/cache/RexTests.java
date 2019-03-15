package com.tingcoder.base.cache;

import java.util.regex.Pattern;

/***
 * @author yfeng
 * @date 2019-03-13 10:21
 */
public class RexTests {
    private static Pattern expressNoPattern = Pattern.compile("\\w*");

    public static void main(String[] args) {
        check("");
        check(" ");
        check("12345");
        check("12345A");
        check("12345*");
        check("12#345");
        check("12 345");
    }
    private static void check(String input){
        boolean matches = expressNoPattern.matcher(input).matches();
        System.out.println(input + " -> " + matches);
    }
}
