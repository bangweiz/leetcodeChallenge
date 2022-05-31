package ClosestSubsequenceSum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,-8,-14,7,-21,21,-7,5,13,-6,30,30};
        int goal = -54;
        System.out.println(solution.minAbsDifference(nums, goal));
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int power = (int) Math.pow(2, n / 2 + 1);
        List<Integer> left = new ArrayList<>(power);
        left.add(0);
        List<Integer> right = new ArrayList<>(power);
        right.add(0);
        for (int i = 0; i < n / 2; i++) {
            int size = left.size();
            for (int j = 0; j < size; j++) {
                left.add(left.get(j) + nums[i]);
            }
        }
        for (int i = n / 2; i < n; i++) {
            int size = right.size();
            for (int j = 0; j < size; j++) {
                right.add(right.get(j) + nums[i]);
            }
        }
        right.sort(Comparator.comparingInt((Integer a) -> a));
        int res = Math.abs(goal);
        for (Integer integer : left) {
            int target = goal - integer;
            int index = Collections.binarySearch(right, target);
            index = index < 0 ? Math.abs(index) - 1 : index;
            if (index < right.size()) {
                res = Math.min(res, Math.abs(target - right.get(index)));
            }
            if (index >= 1) {
                res = Math.min(res, Math.abs(target - right.get(index - 1)));
            }
        }

        return res;
    }
}
