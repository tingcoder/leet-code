package com.tingcoder.leetcode.dp;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/
 * @author yfeng
 * @date 2019-03-15 20:37
 */
public class NumsSameConsecDiff_967 {

    public static void main(String[] args) {
        NumsSameConsecDiff_967 nsc = new NumsSameConsecDiff_967();
        int[] datas = nsc.numsSameConsecDiff(1, 9);
        System.out.println(JSON.toJSONString(datas, true));
    }

    public int[] numsSameConsecDiff(int N, int K) {
        if (N < 1 || N > 9 || K < 0 || K > 9) {
            return new int[]{};
        }
        ArrayList<Integer> results = dealProblem(N, K);
        int[] intResult = new int[results.size()];
        int idx = 0;
        for (Integer val : results) {
            intResult[idx++] = val;
        }
        return intResult;
    }

    private ArrayList<Integer> dealProblem(int len, int gap) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int starIdx = len == 1 ? 0 : 1;
        for (int i = starIdx; i <= 9; i++) {
            int val = i;
            List<List<Integer>> subList = getNumList(val, len - 1, gap);
            if (subList.isEmpty()) {
                continue;
            }
            for (List<Integer> numList : subList) {
                results.add(caculateNum(numList));
            }
        }
        return results;
    }

    private int caculateNum(List<Integer> valNums) {
        int result = 0;
        for (int v : valNums) {
            result = result * 10 + v;
        }
        return result;
    }

    private List<List<Integer>> getNumList(int fistVal, int len, int gap) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (len == 0) {
            results.add(buildNumList(fistVal));
            return results;
        }

        int nexVal = fistVal + gap;
        if (nexVal < 10) {
            List<List<Integer>> nextValList = getNumList(nexVal, len - 1, gap);
            buildListResults(results, fistVal, nextValList);
        }

        int preVal = fistVal - gap;
        if (preVal >= 0 && preVal != nexVal) {
            List<List<Integer>> preValList = getNumList(preVal, len - 1, gap);
            buildListResults(results, fistVal, preValList);
        }
        return results;
    }

    private List<Integer> buildNumList(int val) {
        List<Integer> datas = new ArrayList<Integer>();
        datas.add(val);
        return datas;
    }

    private void buildListResults(List<List<Integer>> totalResults, int curVal, List<List<Integer>> curList) {
        if (curList.isEmpty()) {
            return;
        }
        for (List<Integer> subList : curList) {
            List<Integer> valList = new ArrayList<Integer>();
            valList.add(curVal);
            valList.addAll(subList);
            totalResults.add(valList);
        }
    }
}