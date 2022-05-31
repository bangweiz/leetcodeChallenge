package StringCompressionII;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaaaaaaaaaaaa";
        int k = 0;
        System.out.println(solution.getLengthOfOptimalCompression(s, k));
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] memo = new int[s.length()][k + 1];
        for (int[] v: memo) {
            Arrays.fill(v, -1);
        }
        return helper(s, 0, k, memo);
    }

    private int helper(String s, int start, int k, int[][] memo) {
        if (k < 0) {
            return 999;
        }
        if (k >= s.length() - start) {
            return 0;
        }
        if (memo[start][k] != -1) {
            return memo[start][k];
        }
        int res = helper(s, start + 1, k - 1, memo);
        char firstC = s.charAt(start);
        int count = 0;
        int remaink = k;
        for (int i = start; i < s.length(); i++) {
            if (firstC == s.charAt(i)) {
                count++;
            } else {
                remaink--;
            }
            res = Math.min(res, cal(count) + helper(s, i + 1, remaink, memo));
        }
        memo[start][k] = res;
        return res;
    }

    private int cal(int num) {
        if (num >= 100) {
            return 4;
        } else if (num >= 10) {
            return 3;
        } else if (num >= 2) {
            return 2;
        } else {
            return 1;
        }
    }

}
