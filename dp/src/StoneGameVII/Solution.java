package StoneGameVII;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {7,90,5,1,100,10,10,2};
        System.out.println(solution.stoneGameVII(stones));
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n];
        calSum(stones, sum);
        int[][] memo = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        return helper(0, n - 1, memo, visited, sum);
    }

    private int helper(int start, int end, int[][] memo, boolean[][] visited, int[] sum) {
        if (visited[start][end]) {
            return memo[start][end];
        }
        if (start == end) {
            visited[start][end] = true;
            return 0;
        }
        int res = sum[end] - sum[start] - helper(start + 1, end, memo, visited, sum);
        int temp = start == 0 ? sum[end - 1] : sum[end - 1] - sum[start - 1];
        res = Math.max(res, temp - helper(start, end - 1, memo, visited, sum));
        visited[start][end] = true;
        memo[start][end] = res;
        return res;
    }

    private void calSum(int[] stones, int[] sum) {
        sum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sum[i] = stones[i] + sum[i - 1];
        }
    }
}
