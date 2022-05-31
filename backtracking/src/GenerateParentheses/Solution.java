package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", n, n);
        return list;
    }

    private void helper(List<String> list, String s, int left, int right) {
        if (left == 0) {
            list.add(s + ")".repeat(Math.max(0, right)));
        } else if (left == right) {
            helper(list, s + "(", --left, right);
        } else {
            helper(list, s + "(", left - 1, right);
            helper(list, s + ")", left, right - 1);
        }
    }
}
