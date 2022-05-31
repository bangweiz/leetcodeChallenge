package LargestNumberAtLeastTwiceofOthers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int dominantIndex(int[] nums) {
        return sortMethod(nums);
    }

    // sort
    private int sortMethod(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (Integer a, Integer b) -> nums[b] - nums[a]);
        return nums[index[0]] >= 2 * nums[index[1]] ? index[0] : -1;
    }

    // heap
    private int heapMethod(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(2, Comparator.comparingInt((Integer a) -> nums[a]));
        heap.add(0);
        heap.add(1);
        for (int i = 2; i < nums.length; i++) {
            if (nums[heap.peek()] < nums[i]) {
                heap.poll();
                heap.add(i);
            }
        }
        System.out.println(heap);
        int index1 = heap.poll();
        int index0 = heap.poll();
        return nums[index0] >= 2 * nums[index1] ? index0 : -1;
    }
}
