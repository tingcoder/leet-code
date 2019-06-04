package com.tingcoder.leetcode.dp;

/**
 * Description.
 * https://leetcode-cn.com/problems/divisor-game/
 * @author shizhi
 * Created at 2019-06-02 15:21
 * @version com.tingcoder.leetcode.dp.DivisorGame_1025 v0.1
 */
public class DivisorGame_1025 {

    /**
     * 当N == 1时，爱丽丝无法选择0<x<N，输
     * 当N == 2时，爱丽丝选择0<x<N，只能选择1，N-x = 1,留给鲍勃是输，爱丽丝胜
     * 当N == m时，我们假设
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}