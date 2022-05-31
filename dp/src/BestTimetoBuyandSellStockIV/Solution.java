package BestTimetoBuyandSellStockIV;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }
        int[][] data = new int[k][2];
        data[0][0] = -prices[0];
        data[0][1] = 0;

        for (int i = 1; i < data.length; i++) {
            data[i][0] = Integer.MIN_VALUE;
            data[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            data[0][0] = Math.max(data[0][0], -price);
            data[0][1] = Math.max(data[0][1], data[0][0] + price);

            for (int j = 1; j < data.length; j++) {
                data[j][0] = Math.max(data[j][0], data[j - 1][1] - price);
                data[j][1] = Math.max(data[j][1], data[j - 1][0] + price);
            }
        }

        int res = data[0][1];

        for (int i = 1; i < data.length; i++) {
            res = Math.max(res, data[i][1]);
        }

        return res;
    }
}
