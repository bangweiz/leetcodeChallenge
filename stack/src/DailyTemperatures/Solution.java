package DailyTemperatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = i - index;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
