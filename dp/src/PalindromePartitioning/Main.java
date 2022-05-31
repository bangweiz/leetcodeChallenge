package PalindromePartitioning;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaaaaaaaaaaaaa";
        List<List<String>> res = solution.partition(s);
        for (List<String> r: res) {
            System.out.println(r);
        }
    }
}
