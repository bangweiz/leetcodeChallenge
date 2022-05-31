package CoinChange;


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 4;
        int[] coins = {2};
        System.out.println(solution.coinChange(coins, amount));
    }
}
