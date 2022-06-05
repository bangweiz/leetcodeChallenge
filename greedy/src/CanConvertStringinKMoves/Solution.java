package CanConvertStringinKMoves;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "iqssxdlb";
        String t = "dyuqrwyr";
        int k = 40;
        System.out.println(solution.canConvertString(s, t, k));
    }
    public boolean canConvertString(String s, String t, int k) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int[] moves = new int[26];

        int remainder = k % 26;
        Arrays.fill(moves, k / 26);
        for (int i = 0; i < remainder; i++) {
            moves[i] += 1;
        }

        for (int i = 0; i < n; i++) {
            int move = cal(arrS[i], arrT[i]);
            if (move != 0) {
                if (moves[move - 1] == 0) {
                    return false;
                }
                moves[move - 1] -= 1;
            }
        }

        return true;
    }

    private int cal(char a, char b) {
        if (a == b) {
            return 0;
        } else if (b > a) {
            return b - a;
        } else {
            return 26 - a + b;
        }
    }
}
