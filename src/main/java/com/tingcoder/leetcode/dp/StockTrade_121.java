package com.tingcoder.leetcode.dp;

/***
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author yfeng
 * @date 2019-01-21 12:41
 */
public class StockTrade_121 {
    
    public int maxProfit(int[] prices) {
        int maxProfile = 0;
        if (prices == null || prices.length == 0) {
            return maxProfile;
        }
        int len = prices.length;
        if (len < 2) {
            return maxProfile;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int val = prices[j] - prices[i];
                if (val > maxProfile){
                    maxProfile = val;
                }
            }
        }
        return maxProfile;
    }
}
