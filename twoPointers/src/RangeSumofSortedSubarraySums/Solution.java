package RangeSumofSortedSubarraySums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(solution.rangeSum(nums, 4, 1, 5));
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt((List<Integer> o) -> o.get(0)));
        int mod = 1000000007;
        int res = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i] % mod);
            list.add(i);
            pq.add(list);
        }

        int index = 1;
        while (index <= right) {
            List<Integer> list = pq.poll();
            int sum = list.get(0);
            int i = list.get(1);
            if (index >= left) {
                res = (sum + res) % mod;
            }
            if (i < nums.length - 1) {
                list.set(0, (sum + nums[i + 1]) % mod);
                list.set(1, i + 1);
                pq.add(list);
            }
            index++;
        }

        return res;
    }
}
