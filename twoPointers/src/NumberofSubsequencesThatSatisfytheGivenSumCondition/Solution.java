package NumberofSubsequencesThatSatisfytheGivenSumCondition;

import java.util.Arrays;

public class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int p1 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] + nums[i] > target) {
                p2 = i - 1;
            }
        }
        if (p2 == - 1) {
            return 0;
        } else if (p2 == 0) {
            return 1;
        }

        int[] pow = new int[p2 + 1];
        pow[0] = 1;
        for (int i = 1; i <= p2; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }

        int res = 0;
        while (p1 <= p2) {
            if (nums[p1] + nums[p2] > target) {
                p2--;
            } else {
                res = (pow[p2 - p1 ] + res) % mod;
                p1++;
            }
        }

        return res;
    }
}
