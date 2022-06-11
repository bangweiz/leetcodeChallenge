package MakeTheStringGreat;

import java.util.Stack;

public class Solution {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c: arr) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
