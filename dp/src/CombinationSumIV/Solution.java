package CombinationSumIV;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int remain = i - nums[j];
                if (remain >= 0) {
                    dp[i] += dp[remain];
                }
            }
        }

        return dp[target];
    }
}
