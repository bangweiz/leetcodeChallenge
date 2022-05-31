package WaystoSplitArrayIntoThreeSubarrays;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2,2,5,0};
        System.out.println(solution.waysToSplit(nums));
    }
    public int waysToSplit(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        long res = 0;
        long mod = 1_000_000_007;
        int left = 0;
        int right = 0;
        for (int i = 0; i < sum.length - 2; i++) {
            left = Math.max(i + 1, left);
            while (left < sum.length - 1 && sum[left] < 2 * sum[i]) {
                left++;
            }
            right = Math.max(left, right);
            while (right < sum.length - 1 && sum[right] - sum[i] <= sum[sum.length - 1] - sum[right]) {
                right++;
            }
            res += right - left;
        }

        return (int) ((res + mod) % mod);
    }
}
