package LargestRectangleinHistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = i == heights.length ? 0 : heights[i];
            while (!stack.empty() && currentHeight < heights[stack.peek()]) {
                int index = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, heights[index] * width);
            }
            stack.push(i);
        }

        return res;
    }
}
