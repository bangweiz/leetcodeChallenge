package ParallelCoursesII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] relations = {};
        System.out.println(s.minNumberOfSemesters(11, relations, 2));
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] dp = new int[1 << n];
        int[] prevCourse = new int[n];
        int[] prerequisite = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int[] relation: relations) {
            prevCourse[relation[1] - 1] |= 1 << (relation[0] - 1);
        }

        for (int i = 0; i < prerequisite.length; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    prerequisite[i] |= prevCourse[j];
                }
            }
        }

        dp[0] = 0;
        for (int state = 1; state < dp.length; state++) {
            if (Integer.bitCount(state) - Integer.bitCount(0) <= k && 0 == prerequisite[state]) {
                dp[state] = Math.min(dp[state], dp[0] + 1);
            }
            for (int subset = state; subset > 0; subset = (subset - 1) & state) {
                if (state == subset) {
                    continue;
                }
                if (Integer.bitCount(state) - Integer.bitCount(subset) <= k && (subset & prerequisite[state]) == prerequisite[state]) {
                    dp[state] = Math.min(dp[state], dp[subset] + 1);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
