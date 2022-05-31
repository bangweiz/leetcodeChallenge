package BestTimetoBuyandSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }

        return sell;
    }
}
