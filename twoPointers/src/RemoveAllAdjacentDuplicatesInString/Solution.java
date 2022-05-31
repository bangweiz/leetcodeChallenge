package RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("aaaaaaaa"));
    }
    public String removeDuplicates(String s) {
        int n = s.length();
        int p = 0;
        Stack<Character> stk = new Stack<>();
        while (p < n - 1) {
            char curr = s.charAt(p);
            if (!stk.isEmpty() && curr == stk.peek()) {
                stk.pop();
                p++;
            } else {
                if (curr == s.charAt(p + 1)) {
                    p += 2;
                } else  {
                    stk.add(curr);
                    p++;
                }
            }
        }

        if (p < n) {
            if (!stk.isEmpty() && s.charAt(p) == stk.peek()) {
                stk.pop();
            } else {
                stk.add(s.charAt(p));
            }
        }

        char[] chars = new char[stk.size()];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = stk.pop();
        }
        return String.valueOf(chars);
    }
}
