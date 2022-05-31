package CountDifferentPalindromicSubsequences;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
        System.out.println(solution.countPalindromicSubsequences(s));
    }
}
