package KthLargestElementinaStream;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> heap;
    int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        heap = new PriorityQueue<>(k);
        for (int i = 0; i < k && i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (heap.size() < capacity) {
            heap.add(val);
        } else {
            if (heap.peek() < val) {
                heap.poll();
                heap.add(val);
            }
        }
        return heap.peek();
    }
}
