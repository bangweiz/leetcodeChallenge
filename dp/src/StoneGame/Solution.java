package StoneGame;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {3,7,2,3};
        System.out.println(solution.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(piles[i] - dp[j][i - 1], piles[j] - dp[j + 1][i]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}
