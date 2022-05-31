package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c: arr) {
            switch (c) {
                case '(' -> stack.push(c);
                case '[' -> stack.push(c);
                case '{' -> stack.push(c);
                case ')' -> {
                    if (!stack.isEmpty() && stack.peek() == '(' ) {
                        stack.pop();
                        break;
                    }
                    return false;
                }
                case ']' -> {
                    if (!stack.isEmpty() && stack.peek() == '[' ) {
                        stack.pop();
                        break;
                    }
                    return false;
                }
                case '}' -> {
                    if (!stack.isEmpty() && stack.peek() == '{' ) {
                        stack.pop();
                        break;
                    }
                    return false;
                }
                default -> {
                }
            }
        }
        return stack.isEmpty();
    }
}
