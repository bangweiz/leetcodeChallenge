package MaxNumberofKSumPairs;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        return twoPointer(nums, k);
    }

    // Two Pointer
    private int twoPointer(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
                left++;
                res++;
            }
        }
        return res;
    }

    // Hash Table
    private int hashTable(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int res = 0;
        for (int num: nums) {
            int numCount = map.get(num);
            if (numCount > 0) {
                int target = k - num;
                if (target == num) {
                    if (numCount > 1) {
                        res++;
                        map.replace(num, numCount - 2);
                    }
                } else if (map.containsKey(target)) {
                    int targetCount = map.get(target);
                    if (targetCount > 0) {
                        res++;
                        map.replace(num, numCount - 1);
                        map.replace(target, targetCount - 1);
                    }
                }
            }
        }

        return res;
    }
}
