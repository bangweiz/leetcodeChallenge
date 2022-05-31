package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void helper(List<List<String>> res, List<String> cur, String s, int start) {
        int n = s.length();
        if (start == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int end = start; end < n; end++) {
            if (isPal(s, start, end)) {
                cur.add(s.substring(start, end + 1));
                helper(res, cur, s, end + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int left, int right) {
        int mid = (left + right) / 2;
        while (left <= mid && right >= mid) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
