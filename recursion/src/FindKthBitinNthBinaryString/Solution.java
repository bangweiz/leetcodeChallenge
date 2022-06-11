package FindKthBitinNthBinaryString;

public class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k, 0);
    }

    private char helper(int n, int k, int invertCount) {
        if (n == 0) {
            return invertCount % 2 == 0 ? '0' : '1';
        }

        int length = 1 << (n - 1);
        if (k == length) {
            return invertCount % 2 == 0 ? '1' : '0';
        } else if (k < length) {
            return helper(n - 1, k, invertCount);
        } else {
            return helper(n - 1, length * 2 - k, invertCount + 1);
        }
    }
}
