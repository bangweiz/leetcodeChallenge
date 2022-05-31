package NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty()) {
                if (nums[stack.peek()] < nums[index]) {
                    res[stack.pop()] = nums[index];
                } else {
                    break;
                }
            }
            stack.push(index);
        }
        return res;
    }
}
