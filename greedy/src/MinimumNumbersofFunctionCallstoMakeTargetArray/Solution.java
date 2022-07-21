package MinimumNumbersofFunctionCallstoMakeTargetArray;

public class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        while (true) {
            int temp = helper(nums);
            if (temp == 0) {
                break;
            }
            res += temp;
        }
        return res;
    }

    public int helper(int[] nums) {
        boolean isAllZero = true;
        boolean isAllOne = true;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] > 1) {
                    isAllOne = false;
                }
                isAllZero = false;
                if (nums[i] % 2 != 0) {
                    count++;
                }
                nums[i] /= 2;
            }
        }
        if (isAllZero) {
            return 0;
        }
        if (isAllOne) {
            return count;
        }
        return count + 1;
    }
}
