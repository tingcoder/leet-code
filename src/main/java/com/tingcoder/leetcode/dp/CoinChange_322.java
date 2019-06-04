package com.tingcoder.leetcode.dp;

/**
 * Description.
 * https://leetcode-cn.com/problems/coin-change/
 * @author shizhi
 * Created at 2019-06-02 16:23
 * @version com.tingcoder.leetcode.dp.CoinChange_322 v0.1
 */
public class CoinChange_322 {

    public static void main(String[] args) {
        CoinChange_322 cc = new CoinChange_322();

        int[] coins = {1, 2, 5};
        for (int i = 6; i < 20; i++) {
            System.out.println(i + " -> " + cc.coinChange(coins, i));
        }
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            countCurrentAmount(dp, coins, i);
        }

        return dp[amount] > 0 ? dp[amount] : -1;
    }

    private void countCurrentAmount(int[] dp, int[] coins, int curAmount) {
        for (int curCoin : coins) {
            if (curCoin == curAmount) {
                dp[curAmount] = 1;
                return;
            }
            if (curCoin < curAmount && dp[curAmount - curCoin] > 0) {
                if (dp[curAmount] == 0) {
                    dp[curAmount] = dp[curAmount - curCoin] + 1;
                } else {
                    dp[curAmount] = Math.min(dp[curAmount], dp[curAmount - curCoin] + 1);
                }
            }
        }
    }
}