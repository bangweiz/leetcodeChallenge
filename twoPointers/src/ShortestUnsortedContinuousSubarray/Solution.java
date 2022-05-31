package ShortestUnsortedContinuousSubarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5,4,2,3};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] <= nums[left + 1]) {
            left++;
        }
        while (left < right && nums[right] >= nums[right - 1]) {
            right--;
        }
        int res = 0;
        if (left == right) {
            return res;
        } else if (left + 1 == right) {
            left--;
            right++;
        }
        res = right - left - 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        while (left >= 0 && right < nums.length) {
            if (nums[left] <= min && nums[right] >= max) {
                return res;
            }
            if (nums[left] > min) {
                max = Math.max(nums[left], max);
                res++;
                left--;
            }
            if (nums[right] < max) {
                min = Math.min(nums[right], min);
                res++;
                right++;
            }
        }
        while (left >= 0) {
            if (nums[left] > min) {
                res++;
                left--;
            } else {
                break;
            }
        }

        while (right < nums.length) {
            if (nums[right] < max) {
                res++;
                right++;
            } else  {
                break;
            }
        }
        return res;
    }
}
