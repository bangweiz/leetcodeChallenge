package MaxDotProductofTwoSubsequences;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {2,1,-2,5};
        int[] num2 = {3,0,-6};
        System.out.println(solution.maxDotProduct(num1, num2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < nums2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
        }

        for (int i = 1; i < nums1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
            for (int j = 1; j < nums2.length; j++) {
                int res1 = Math.max(nums1[i] * nums2[j], nums1[i] * nums2[j] + dp[i - 1][j - 1]);
                int res2 = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(res1, res2);
            }
        }

        return dp[nums1.length - 1][nums2.length - 1];
    }
}
