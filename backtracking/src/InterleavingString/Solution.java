package InterleavingString;

public class Solution {
    private int[][] map;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        map = new int[s1.length() + 1][s2.length() + 1];
        return helper(s1, s2, s3, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i1, int i2) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }

        if (map[i1][i2] != 0) {
            return map[i1][i2] == 1;
        }

        boolean res1 = false;
        boolean res2 = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
            res1 = helper(s1, s2, s3, i1 + 1, i2);
        }

        if (res1) {
            map[i1][i2] = 1;
            return true;
        }
        map[i1][i2] = -1;

        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
            res2 = helper(s1, s2, s3, i1, i2 + 1);
        }

        map[i1][i2] = res2 ? 1 : -1;

        return res2;
    }
}
