package MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,3,5,1,4,2,-9};
        int target = 6;
        System.out.println(solution.maxNonOverlapping(nums, target));
    }
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        int prev = -1;
        map.put(0, -1);
        map.put(nums[0], 0);
        if (prefixSum[0] == target) {
            int[] pair = {0, 0};
            list.add(pair);
            prev = 0;
        }
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            int t = prefixSum[i] - target;
            if (map.containsKey(t)) {
                int index = map.get(t) + 1;
                if (index > prev) {
                    int[] pair = {index, i};
                    list.add(pair);
                    prev = index;
                }
            }
            map.put(prefixSum[i], i);
        }

        int res = 0;
        prev = Integer.MAX_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] pair = list.get(i);
            if (pair[1] < prev) {
                res++;
                prev = pair[0];
            }
        }

        return res;
    }
}
