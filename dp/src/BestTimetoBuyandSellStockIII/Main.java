package BestTimetoBuyandSellStockIII;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(solution.maxProfit(prices));
    }
}
