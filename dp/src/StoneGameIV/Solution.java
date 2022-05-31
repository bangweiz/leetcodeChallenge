package StoneGameIV;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.winnerSquareGame(8));
    }
    public boolean winnerSquareGame(int n) {
        List<Integer> squares = new ArrayList<>();
        squares.add(1);
        while (squares.get(squares.size() - 1) < n) {
            squares.add((squares.size() + 1) * (squares.size() + 1));
        }

        boolean[] dp = new boolean[n + 1];
        dp[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int k: squares) {
                if (k > i) {
                    break;
                } else if (k == i) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = dp[i] || !dp[i - k];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
