package BackspaceStringCompare;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(solution.backspaceCompare(s, t));
    }
    public boolean backspaceCompare(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c: arr1) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.add(c);
            }
        }
        for (char c: arr2) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.add(c);
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        } else {
            while (!stack1.isEmpty()) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}
