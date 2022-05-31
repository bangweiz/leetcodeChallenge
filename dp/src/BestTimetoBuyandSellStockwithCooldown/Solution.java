package BestTimetoBuyandSellStockwithCooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = -prices[0];
        int sold = 0;
        int cooldown = 0;

        for (int i = 1; i < n; i++) {
            int price = prices[i];
            int tempBuy = Math.max(buy, cooldown - price);
            int tempSold = Math.max(sold, buy + price);
            int tempCooldown = Math.max(cooldown, sold);
            buy = tempBuy;
            sold = tempSold;
            cooldown = tempCooldown;
        }

        return Math.max(sold, cooldown);
    }
}
