package CapacityToShipPackagesWithinDDays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(solution.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int[] prefixSum = new int[weights.length];
        int left = weights[0];
        prefixSum[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            prefixSum[i] = weights[i] + prefixSum[i - 1];
        }
        int right = prefixSum[prefixSum.length - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(mid, prefixSum, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int capacity, int[] sum, int days) {
        int target = capacity;
        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > target) {
                count++;
                target = capacity + sum[i - 1];
            }
        }
        return days >= count + 1;
    }
}
