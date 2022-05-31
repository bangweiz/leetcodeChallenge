package MaximumScoreofaGoodSubarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,4,3,7,4,5};
        int k = 5;
        System.out.println(solution.maximumScore(nums, k));
    }
    public int maximumScore(int[] nums, int k) {
        int min = nums[k];
        int score = nums[k];
        int i = k;
        int j = k;
        while (i > 0 && j < nums.length - 1) {
            if (nums[i - 1] < min && nums[j + 1] < min) {
                min = Math.max(nums[i - 1], nums[j + 1]);
                score = Math.max(score, min * (j - i + 2));
                if (nums[i - 1] < nums[j + 1]) {
                    j++;
                } else {
                    i--;
                }
            } else {
                if (nums[i - 1] >= min) {
                    score = Math.max(score, min * (j - i + 2));
                    i--;
                }
                if (nums[j + 1] >= min) {
                    score = Math.max(score, min * (j - i + 2));
                    j++;
                }
            }
        }

        while (i - 1 >= 0) {
            min = Math.min(min, nums[i - 1]);
            score = Math.max(score, min * (j - i + 2));
            i--;
        }

        while (j + 1 < nums.length) {
            min = Math.min(min, nums[j + 1]);
            score = Math.max(score, min * (j - i + 2));
            j++;
        }

        return score;
    }
}
