package BestTimetoBuyandSellStockII;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            int temp = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, buy + prices[i]);
            buy = temp;
        }

        return sell;
    }
}
