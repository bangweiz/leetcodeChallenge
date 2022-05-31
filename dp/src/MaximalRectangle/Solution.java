package MaximalRectangle;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
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
