package KthLargestElementinanArray;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
