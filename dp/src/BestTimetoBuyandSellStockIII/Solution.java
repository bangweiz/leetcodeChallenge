package BestTimetoBuyandSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return Math.max(sell2, sell1);
    }
}
