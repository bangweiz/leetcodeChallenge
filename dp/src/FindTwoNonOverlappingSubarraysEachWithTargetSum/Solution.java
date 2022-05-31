package FindTwoNonOverlappingSubarraysEachWithTargetSum;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,2,2,4,3};
        System.out.println(solution.minSumOfLengths(arr, 2));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int[] memo = new int[arr.length];
        memo[0] = arr[0] == target ? 1 : 999999;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 999999;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            q.add(i);
            while (sum > target) {
                sum -= arr[q.remove()];
            }
            if (sum == target) {
                if (q.size() > 0 && q.peek() != 0) {
                    res = Math.min(res, memo[q.peek() - 1] + q.size());
                }
                memo[i] = Math.min(memo[i - 1], q.size());
            } else {
                memo[i] = memo[i - 1];
            }
        }

        return res == 999999 ? -1 : res;
    }
}
