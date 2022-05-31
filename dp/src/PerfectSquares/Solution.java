package PerfectSquares;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> squares = new ArrayList<>();
        int index = 0;
        while (true) {
            int square = index * index;
            if (square > n) {
                break;
            } else {
                squares.add(square);
                index++;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < squares.size(); j++) {
                int remain = i - squares.get(j);
                if (remain > 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[remain]);
                } else if (remain == 0) {
                    dp[i] = 1;
                }
            }
        }

        return dp[n];
    }
}
