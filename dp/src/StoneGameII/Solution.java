package StoneGameII;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {2,7,9,4,4,2,7,9};
        System.out.println(solution.stoneGameII(piles));
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] sum = new int[n][n];
        int[][][] memo = new int[n][n][2];
        buildSum(piles, sum);
        int[] res = helper(piles, 0, 1, sum, memo);
        return res[0];
    }

    public int[] helper(int[] piles, int start, int m, int[][] sum, int[][][] memo) {
        if (memo[start][m][0] != 0) {
            return memo[start][m];
        }

        int range = m * 2 - 1;
        int n = piles.length;
        if (start + range >= n - 1) {
            memo[start][m][0] = sum[start][n - 1];
            return memo[start][m];
        }


        int[] res = {0,0};
        for (int i = 0; i <= range; i++) {
            int left = sum[start][start + i];
            int[] remain = helper(piles, start + i + 1, Math.max(i + 1, m), sum, memo);
            if (left + remain[1] > res[0]) {
                res[0] = left + remain[1];
                res[1] = remain[0];
            }
        }

        memo[start][m] = res;

        return res;
    }

    public void buildSum(int[] piles, int[][] sum) {
        for (int i = 0; i < piles.length; i++) {
            sum[i][i] = piles[i];
            for (int j = i + 1; j < piles.length; j++) {
                sum[i][j] = sum[i][j - 1] + piles[j];
            }
        }
    }
}
