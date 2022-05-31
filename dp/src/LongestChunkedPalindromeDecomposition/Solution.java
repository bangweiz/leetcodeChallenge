package LongestChunkedPalindromeDecomposition;

public class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int pointer1 =  0;
        int end = n - 1;
        int res = 0;

        for (int pointer2 = n - 1; pointer2 >= pointer1; pointer2--) {
            if (pointer1 == pointer2) {
                return ++res;
            }
            if (text.charAt(pointer1) == text.charAt(pointer2)) {
                boolean flag = true;
                for (int i = 1; i + pointer2 <= end; i++) {
                    if (text.charAt(pointer1 + i) != text.charAt(pointer2 + i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    pointer1 += end - pointer2 + 1;
                    end = pointer2 - 1;
                    res += 2;
                }
            }
        }

        return res;
    }
}
