package LargestMergeOfTwoStrings;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "abcabc";
        String word2 = "abdcaba";
        System.out.println(solution.largestMerge(word1, word2));
    }
    public String largestMerge(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (p1 < word1.length() || p2 < word2.length()) {
            if (aLagerThanB(a, p1, b, p2)) {
                sb.append(a[p1++]);
            } else {
                sb.append(b[p2++]);
            }
        }
        return sb.toString();
    }

    private boolean aLagerThanB(char[] a, int startA, char[] b, int startB) {
        while (startA < a.length && startB < b.length) {
            if (a[startA] > b[startB]) {
                return true;
            } else if (a[startA] < b[startB]) {
                return false;
            } else {
                startA++;
                startB++;
            }
        }
        return startA < a.length;
    }
}
