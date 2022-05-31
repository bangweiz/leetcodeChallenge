package LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 1) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == ')') {
                if (stk1.isEmpty()) {
                    stk2.add(i);
                } else {
                    stk1.pop();
                    if (stk1.isEmpty()) {
                        max = Math.max(max, i - (stk2.isEmpty() ? -1 : stk2.peek()));
                    } else {
                        max = Math.max(max, i - stk1.peek());
                    }
                }
            } else {
                stk1.add(i);
            }
        }

        return max;
    }
}
